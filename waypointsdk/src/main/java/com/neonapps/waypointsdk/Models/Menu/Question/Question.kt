package com.neonapps.waypointsdk.Models.Menu.Question

data class Question(
    // Properties that will come from restaurant panel
    var title : String,
    var options : List<Option>,
    var isMultipleSelectionEnabled : Boolean,
    // Properties that may be added during order
){

 }
