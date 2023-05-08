package com.neonapps.waypointsdk.Models

import com.neonapps.waypointsdk.Globals
import com.neonapps.waypointsdk.Models.Order.Order
import com.neonapps.waypointsdk.Models.Users.Waiter
import java.lang.reflect.Array.get

class Table(
    var number: Int,
    var capacity: Int,
    var status: TableStatus = TableStatus.AVAILABLE,
    var section : String,
    var waiter: Waiter?
) {
    var activeOrder: Order?
        get() = Globals.arrOrders.firstOrNull { it.table == this && it.isActive == true }
        set(value) {
            this.activeOrder = value
        }


    override fun equals(other: Any?): Boolean {
        other as Table
        return this.number == other.number
    }

    fun getTables(forSection : String) : List<Table>{
        return Globals.arrTables.filter{
            it.section == forSection
        }
    }

    fun getTables(forStatus : TableStatus) : List<Table>{
        return Globals.arrTables.filter{
            it.status == forStatus
        }
    }
}

enum class TableStatus {
    AVAILABLE,
    OCCUPIED,
    RESERVED,
}
