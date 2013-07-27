<?php
require_once('tracker.php');
?>
<html>

    <head>
        <title>MI6 Tracker</title>
        <link href="misc/style.css" rel="stylesheet" type="text/css"/>
    </head>

    <body class="fd_content">
        <p><img class="fd_img_center" src="misc/header.jpg" width=735 height=127 /></p>
        <p>//You've just been tracked by <a href="https://github.com/ahughes117/mi6" target="_blank"><strong>MI6 IP Tracker</strong></a></p>

        <br>
        <?php
        echo "<p><strong>IP Address:</strong> {$ip->ip}</p>";
        echo "<p><strong>Host:</strong> {$ip->hostname}</p>";
        echo "<p><strong>City:</strong> {$ip->city}</p>";
        echo "<p><strong>Region:</strong> {$ip->region}</p>";
        echo "<p><strong>Country:</strong> {$ip->country}</p>";
        echo "<p><strong>Country Code:</strong> {$ip->country_code}</p>";
        echo "<p><strong>Longitude:</strong> {$ip->longitude}</p>";
        echo "<p><strong>Latitude:</strong> {$ip->latitude}</p>";
        echo "<p><strong>Agent:</strong> {$ip->agent}</p>";
        echo "<p><strong>Domain:</strong> {$ip->domain}";
        ?>

    </body>
</html>

