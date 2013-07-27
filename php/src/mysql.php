<?php

/*
 * MySQL connector wrapper class
 * All basic functionality is included here.
 * 
 */

require_once('config.php');

global $con;
$con = new MySQL();

class MySQL {

    public $config;
    public $mysqli;

    public function MySQL() {
        $this->config = new Config();
        $this->mysqli = new mysqli($this->config->db_url, $this->config->db_user,
                        $this->config->db_pass, $this->config->db_schema);
    }

    /**
     * This function creates and returns a prepared statement.
     * 
     * @param type $aStatement
     * @return type
     */
    public function prepare_statement($aStatement) {
        return ($this->mysqli->prepare($aStatement));
    }

    /**
     * This function executes an update and returns true if succesful, false if
     * failed.
     * 
     * @param type $aQuery
     * @return boolean
     */
    public function executeUpdate($aQuery) {
        if(($this->mysqli->query($aQuery)) === TRUE) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * This function executes a query and returns the result. DO NOT USE with 
     * parameter passing, use a prepared statement instead.
     * 
     * USED ONLY FOR STATIC FIXED QUERIES
     * 
     * @param type $aQuery
     * @return type
     */
    public function send_query($aQuery) {
        $result = $this->mysqli->query($aQuery);
        return $result;
    }
    
    /**
     * Returns the last inserted id
     * 
     * @return type
     */
    public function inserted_id() {
        return $this->mysqli->insert_id;
    }

}

?>
