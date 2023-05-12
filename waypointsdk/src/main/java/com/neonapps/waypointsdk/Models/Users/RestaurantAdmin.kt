package com.neonapps.waypointsdk.Models.Users

data class RestaurantAdmin(
    override var email: String,
    override var name: String,
    override var surname: String,
    override var password: String,
) : User(email, name, surname, password){
    init {
        this.type = UserType.WAITER
    }
}