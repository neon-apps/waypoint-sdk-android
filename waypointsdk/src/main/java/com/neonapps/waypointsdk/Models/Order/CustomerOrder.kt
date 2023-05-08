package com.neonapps.waypointsdk.Models.Order

import com.neonapps.waypointsdk.Models.Users.Customer

class CustomerOrder(
    var customer: Customer,
    var orderItems: List<OrderItem>
) {

    val price: Double
        get() = orderItems.fold(0.0) { acc, orderItem -> acc + orderItem.price }
}