package com.neonapps.waypointsdk.Models.Users

import com.neonapps.waypointsdk.Globals
import com.neonapps.waypointsdk.Models.Menu.KitchenType
import com.neonapps.waypointsdk.Models.Table

class Waiter(
    var isAuthoriedForCashPayment: Boolean,
    var kitchenTypes: List<KitchenType>,
    email: String,
    name: String,
    surname: String,
    password: String
) : User(email, name, surname, password) {

    val assignedTables: List<Table>
        get() = Globals.arrTables.filter {

            it.waiter == this }

    init {
        this.type = UserType.WAITER
    }
}