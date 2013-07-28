<?php

require_once('src/ip.php');

if (!isset($_GET['ip']))
    $my_ip = insert_ip();
else {
    $my_ip = insert_ip();
    $request_ip = insert_ip_request();
}
?>
