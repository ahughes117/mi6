<?php

/*
 * Contains all alexa oriented functionality
 */


function alexa_rank($url){
    $xml = simplexml_load_file("http://data.alexa.com/data?cli=10&url=".$url);
    if(isset($xml->SD)):
        return $xml->SD->REACH->attributes();
        var_dump($xml->SD->REACH->attributes());
    endif;
}

