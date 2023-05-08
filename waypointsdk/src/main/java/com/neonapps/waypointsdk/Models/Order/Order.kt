package com.neonapps.waypointsdk.Models.Order

import com.neonapps.waypointsdk.Globals
import com.neonapps.waypointsdk.Models.Table

class Order(
    var number: Int,
    var customerOrders : ArrayList<CustomerOrder>,
    var table : Table,
    var isPaid: Boolean,
    var isActive : Boolean,
    var status: OrderStatus = OrderStatus.PENDING

) : Comparable<Order> {

    val price: Double
        get() = customerOrders.sumByDouble { it.price }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        other as Order

        return number == other.number
    }

    override fun hashCode(): Int {
        return number
    }

    override fun compareTo(other: Order): Int {
        return number.compareTo(other.number)
    }
}

enum class OrderStatus {
    PENDING,
    PREPARING,
    DONE,
    CANCELLED
}




fun getOrders(forStatus: OrderStatus): List<Order> {
    return Globals.arrOrders.filter { it.status == forStatus }
}