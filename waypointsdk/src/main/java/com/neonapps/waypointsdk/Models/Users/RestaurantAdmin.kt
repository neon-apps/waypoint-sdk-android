package com.neonapps.waypointsdk.Models.Users

class RestaurantAdmin(
    email: String,
    name: String,
    surname: String,
    password: String,
) : User(email, name, surname, password){
    init {
        this.type = UserType.WAITER
    }
}