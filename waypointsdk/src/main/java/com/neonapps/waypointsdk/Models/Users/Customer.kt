package com.neonapps.waypointsdk.Models.Users

import com.neonapps.waypointsdk.Models.Event
import com.neonapps.waypointsdk.Models.Menu.Food
import com.neonapps.waypointsdk.Models.Reservation
import com.neonapps.waypointsdk.Models.Restaurant

data class Customer(
    override var email: String,
    override var name: String,
    override var surname: String,
    override var password: String,
    var profileImageURL : String,
    var favoriteFoods :List<Food?>?,
    var favoriteRestaurants : List<Restaurant?>?,
    var reservations :List<Reservation?>?,
    var participatedEvents :List<Event?>?,
    var friends : List<Customer?>?,
    var isFriend : Boolean?,


    ) : User(email, name, surname, password, ) {



    init {
        type = UserType.CUSTOMER

    }

}