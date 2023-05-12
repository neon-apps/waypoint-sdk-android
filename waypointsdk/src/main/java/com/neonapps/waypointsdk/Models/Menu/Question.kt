package com.neonapps.waypointsdk.Models.Menu

data class Question(
    // Properties that will come from restaurant panel
    var title : String,
    var options : List<String>,
    // Properties that may be added during order
    var answer : String?
){

 }
