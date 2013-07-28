<?php

require_once('src/ip.php');

if (!isset($_POST['ip']))
    $my_ip = insert_ip();
else {
    $my_ip = insert_ip();

    $ip = gethostbyname(urldecode($_POST['ip']));
    if (filter_var($_POST['ip'], FILTER_VALIDATE_IP))
        $request_ip = insert_request($_POST['ip']);
    elseif (strcmp($ip, $_POST['ip']) != 0){
        $request_ip = insert_request($ip);
    }
}
?>
