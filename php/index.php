<?php
//remove for production version
error_reporting(E_ALL | E_STRICT);
ini_set("display_errors", "1");

require_once('tracker.php');
?>
<html>

    <head>
        <title>MI6 Tracker</title>
        <link href="misc/style.css" rel="stylesheet" type="text/css"/>
    </head>

    <body class="fd_content">
        <p><img class="fd_img_center" src="misc/header.jpg" width=735 height=127 /></p>

        <?php
        if (isset($_GET['ip'])) {
            echo "<p>//Below you can find the info you are looking for, brought to you by <a href='https://github.com/ahughes117/mi6' target='_blank'><strong>MI6 IP Tracker</strong></a></p>";
            echo "<p>//The ip of the request is <strong>{$_SERVER['REMOTE_ADDR']}</strong>. Here is the info you are looking for:</p><br>";
            
            if (isset($request_ip))
                print_ip($request_ip);
            else
                echo "<p><strong>The ip you provided was invalid.</strong></p><br>";
            
            echo "<p><i>Your info is: </i></p>";
        } else {
            echo "<p>//You've just been tracked by <a href='https://github.com/ahughes117/mi6' target='_blank'><strong>MI6 IP Tracker</strong></a></p><br>";
        }
        print_ip($my_ip);

        function print_ip($ip) {
            echo "<blockquote><p><strong>IP Address:</strong> {$ip->ip}</p>";
            echo "<p><strong>Host:</strong> {$ip->hostname}</p>";
            echo "<p><strong>City:</strong> {$ip->city}</p>";
            echo "<p><strong>Region:</strong> {$ip->region}</p>";
            echo "<p><strong>Country:</strong> {$ip->country}</p>";
            echo "<p><strong>Country Code:</strong> {$ip->country_code}</p>";
            echo "<p><strong>Longitude:</strong> {$ip->longitude}</p>";
            echo "<p><strong>Latitude:</strong> {$ip->latitude}</p>";
            echo "<p><strong>Agent:</strong> {$ip->agent}</p>";
            echo "<p><strong>Domain:</strong> {$ip->domain}</p><br></blockquote>";
        }
        ?>

    </body>
</html>

