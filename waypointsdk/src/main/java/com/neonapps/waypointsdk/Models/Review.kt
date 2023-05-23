package com.neonapps.waypointsdk.Models

import com.neonapps.waypointsdk.Models.Users.Customer

data class Review(
    var rate : Double,
    var comment : String,
    var customer: Customer,
    var restaurant: Restaurant
) {
}