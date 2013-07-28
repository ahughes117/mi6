<?php

require_once ('mysql.php');

class Ip {

    public $ip;
    public $agent;
    public $domain;
    public $hits;
    public $request;
    public $request_source;
    public $hostname;
    public $city;
    public $region;
    public $country;
    public $country_code;
    public $latitude;
    public $longitude;
    public $post_code;
    public $timezone;
    public $date_created;
    public $date_modified;

}

/**
 * Acquires more info about an IP Address
 * 
 * @return \Ip
 */
function acquire_ip_details($ip_addr) {
    $ip = new Ip();

    $ip->ip = $ip_addr;
    $ip->agent = $_SERVER['HTTP_USER_AGENT'];
    $ip->domain = $_SERVER['HTTP_HOST'] . $_SERVER['PHP_SELF'];

    $ip->hostname = gethostbyaddr($ip->ip);

    $geoplugin = unserialize(file_get_contents('http://www.geoplugin.net/php.gp?ip=' . $ip->ip));

    $ip->city = $geoplugin['geoplugin_city'];
    $ip->region = $geoplugin['geoplugin_region'];
    $ip->country = $geoplugin['geoplugin_countryName'];
    $ip->country_code = $geoplugin['geoplugin_countryCode'];

    if (is_numeric($geoplugin['geoplugin_latitude']) && is_numeric($geoplugin['geoplugin_longitude'])) {
        $ip->latitude = $geoplugin['geoplugin_latitude'];
        $ip->longitude = $geoplugin['geoplugin_longitude'];
    }

    return $ip;
}

/**
 * Inserts an IP with full details in the database
 * 
 * @global type $con
 * @return boolean
 * @throws Exception
 */
function insert_ip() {
    global $con;
    //if address exists, skip all this and update hits

    $ip = acquire_ip_details($_SERVER['REMOTE_ADDR']);


    $query = "
        INSERT INTO ip (ip, agent, domain, Hostname, City, Region, Country, 
        CountryCode, Longitude, Latitude, DateCreated) VALUES 
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP) ";

    try {
        $stmt = $con->prepare_statement($query);

        //checking if query well written
        if (!$stmt)
            throw new Exception();

        $stmt->bind_param("ssssssssss", $ip->ip, $ip->agent, $ip->domain, $ip->hostname, $ip->city, $ip->region, $ip->country, $ip->country_code, $ip->longitude, $ip->latitude);
        $stmt->execute();

        $stmt->close();
        $con->close_connection();
    } catch (Exception $x) {
        $con->close_connection();
    }
    return $ip;
}

/**
 * Checks whether an IP exists in the database
 * 
 * @global type $con
 * @param type $ip_addr
 * @param type $request
 * @return null
 */
function ip_exists($ip_addr, $domain, $agent) {
    global $con;

    $query = "
        SELECT count(*) 
        FROM ip 
        WHERE ip = ? AND agent = ? AND domain = ? ";

    try {
        $stmt = $con->prepare_statement($query);
        
        //checking if query well written
        if(!$stmt)
            throw new Exception();
        
        $stmt->bind_param("sss", $ip_addr, $domain, $agent);

        $stmt->execute();
        $stmt->bind_result($num);

        while ($stmt->fetch()) {
            if ($num == 1)
                $exists = true;
            else
                $exists = false;
        }
        
        $stmt->close();
        return $exists;
    } catch (Exception $x) {
        return null;
    }
}

/**
 * Increments the hits of an ip by one.
 * 
 * @global type $con
 * @param type $ip
 * @param type $agent
 * @param type $domain
 * @return boolean
 * @throws Exception
 */
function update_hits($ip, $agent, $domain) {
    global $con;
    
    $sel_query = "
        SELECT Hits 
        FROM ip 
        WHERE ip = ? AND agent = ? AND domain = ? ";
    
    $upd_query = "
        UPDATE ip 
        SET Hits = ? 
        WHERE ip = ? AND agent = ? AND domain = ? ";
    
    try {
        //first acquiring current hits
        $stmt = $con->prepare_statement($sel_query);
        
        //checking if query well written
        if(!$stmt)
            throw new Exception();
        
        
        $stmt->execute();
        
        $stmt->bind_result($hits);
        while($stmt->fetch())
            $hits = $hits;
        
        $stmt->close();
        $stmt = null;
        
        //now updating them
        $stmt = $con->prepare_statement($upd_query);
        
        //checking if query well written again
        if(!$stmt)
            throw new Exception();
        
        $stmt->bind_param("isss", $hits, $ip, $agent, $domain);
        
        $stmt->execute();
        if($stmt->affected_rows != 1)
            throw new Exception();
        
        $stmt->close();
        return true;
    } catch(Exception $x) {
        return false;
    }
}
?>
