package com.neonapps.waypointsdk.Models

import kotlin.random.Random

class Restaurant(
    var logoURL : String,
    var photos : List<String>,
    var name : String,
    var description : String,
    var isOpen : Boolean,
    var reviews : List<Review>,
    var minPricePerPerson : Int,
    var maxPricePerPerson : Int,
    var pricingRate : Int = Random.nextInt(1,5)
) {
    var averageRate: Double
        get() = reviews.fold(0.0) { acc, review ->
            acc + review.rate.toDouble()
        } / reviews.size.toDouble()
        set(value) {
            this.averageRate = value
        }
    var numberOfRates : Int = reviews.size
}