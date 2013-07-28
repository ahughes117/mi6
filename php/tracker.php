<?php

require_once('src/ip.php');

if (!isset($_GET['ip']))
    $my_ip = insert_ip();
else {
    $my_ip = insert_ip();

    if (filter_var($_GET['ip'], FILTER_VALIDATE_IP))
        $request_ip = insert_request($_GET['ip']);
}
?>
