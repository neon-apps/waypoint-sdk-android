package com.neonapps.waypointsdk.Models

import com.neonapps.waypointsdk.Models.Users.Customer

class Event(
    var imageURL : String,
    var title : String,
    var description : String,
    var price : Double,
    var features : List<String>,
    var participants : List<Customer>
) {
}