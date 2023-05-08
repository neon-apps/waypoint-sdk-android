package com.neonapps.waypointsdk.Models.Users


open class User(
    var email : String,
    var name : String,
    var surname : String,
    var password: String,
    var type : UserType = UserType.NONE,
)
{
    override fun equals(other: Any?): Boolean {

        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        other as User

        if (email != other.email) return false

        return true
    }
}

enum class UserType {
    WAITER,
    CUSTOMER,
    KITCHEN,
    RESTAURANT_ADMIN,
    NONE;
}

