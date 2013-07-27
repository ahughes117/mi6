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
<p>//Just tracked by <a href="https://github.com/ahughes117/mi6" target="_blank"><strong>MI6 IP Tracker</strong></a></p>

<br>
<?php
echo "<p><strong>IP Address:</strong> {$_SERVER['REMOTE_ADDR']}</p>";
echo "<p><strong>Agent:</strong> {$_SERVER['HTTP_USER_AGENT']}</p>";
echo "<p><strong>Domain:</strong> {$_SERVER['HTTP_HOST']}{$_SERVER['PHP_SELF']}";
?>

</body>
</html>

