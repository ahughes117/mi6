<?php

require_once ('mysql.php');

class Ip {
    
    public $ip;
    public $agent;
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

function insert_ip() {
    global $con;
    $query = "
        INSERT INTO ip (ip, agent, domain, DateCreated) VALUES 
        (?, ?, ?, CURRENT_TIMESTAMP) ";
    
    try {
        $stmt = $con->prepare_statement($query);
        
        //checking if query well written
        if(!$stmt)
            throw new Exception();
        
        $domain = $_SERVER['HTTP_HOST'] . $_SERVER['PHP_SELF'];
        $stmt->bind_param("sss", $_SERVER['REMOTE_ADDR'], $_SERVER['HTTP_USER_AGENT'],
                $domain);
        $stmt->execute();
        
        $id = $con->inserted_id();
        
        if($id == 0)
            throw new Exception();
        
        $stmt->close();
        return $id;
    } catch(Exception $x) {
        return false;
    }
}
?>
