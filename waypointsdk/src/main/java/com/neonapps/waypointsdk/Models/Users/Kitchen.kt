package com.neonapps.waypointsdk.Models.Users

class Kitchen(
    email: String,
    name: String,
    surname: String,
    password: String,
) : User(email, name, surname,password ) {
    init {
        type = UserType.KITCHEN
    }
}