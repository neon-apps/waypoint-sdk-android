package com.neonapps.waypointsdk.Models

import com.neonapps.waypointsdk.Globals
import java.util.Date

data class Reservation(
    var number : Int,
    var date : Date,
    var numberOfSeats : Int,
    var specialDay : String,
    var isCancelled : Boolean = false
) {

    fun getReservations(forDate : Date): List<Reservation>{
        return Globals.arrReservations.filter{it.date == forDate}
    }
}