package com.neonapps.waypointsdk.Models.Order

import com.neonapps.waypointsdk.Models.Menu.Food
import com.neonapps.waypointsdk.Models.Menu.Question.Question

data class OrderItem(
    var food: Food,
    var count: Int,
    var answeredQuestions: List<Question>,
    var customerNote: String,
    var isSelected : Boolean? = false,
) {
    var price : Double = food.price*count.toDouble()

}