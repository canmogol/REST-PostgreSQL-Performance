<?php

$dbconn = pg_connect("host=centos dbname=postgres user=postgres password=postgres")
    or die('Could not connect: ' . pg_last_error());

$query = 'SELECT * FROM city';

$result = pg_query($dbconn, $query) 
    or die('Query failed: ' . pg_last_error());


header("Content-Type: application/json");

echo json_encode(pg_fetch_all($result));

// $num_rows = pg_num_rows($result);
// error_log($num_rows);

pg_free_result($result);
pg_close($dbconn);
?>