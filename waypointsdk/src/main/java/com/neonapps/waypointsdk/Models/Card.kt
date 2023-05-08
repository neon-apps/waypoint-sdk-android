package com.neonapps.waypointsdk.Models

class Card(
    var number : String,
    var name : String,
    var surname : String,
    var cvv : String,
    var expirationYear : Int,
    var expirationMonth : Int
) {
    override fun equals(other: Any?): Boolean {
        other as Card
        return this.number == other.number
    }
}