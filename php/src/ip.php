<?php

require_once ('mysql.php');

class Ip {

    public $ip;
    public $agent;
    public $domain;
    public $hostname;
    public $country_code;
    public $city;
    public $isp;
    public $latitude;
    public $longitude;
    public $timezone;
    public $post_code;
    public $date_created;
    public $date_modified;

}

/**
 * Acquires more info about an IP Address
 * 
 * @return \Ip
 */
function acquire_ip_details() {
    $ip = new Ip();

    $ip->ip = $_SERVER['REMOTE_ADDR'];
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
    $ip = acquire_ip_details();

    global $con;
    $query = "
        INSERT INTO ip (ip, agent, domain, Hostname, City, Region, Country, 
        CountryCode, Longitude, Latitude, DateCreated) VALUES 
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP) ";

    try {
        $stmt = $con->prepare_statement($query);

        //checking if query well written
        if (!$stmt)
            throw new Exception();
        
        $stmt->bind_param("ssssssssss", $ip->ip, $ip->agent, $ip->domain, $ip->hostname, 
                $ip->city, $ip->region, $ip->country, $ip->country_code, $ip->longitude, $ip->latitude);
        $stmt->execute();
        
        $stmt->close();
        $con->close_connection();
        
    } catch (Exception $x) {
        $con->close_connection();
    }
    return $ip;
}

?>
