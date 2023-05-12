package com.neonapps.waypointsdk.Models

import com.neonapps.waypointsdk.Models.Order.Order
import com.neonapps.waypointsdk.Models.Users.Waiter
import java.util.Date

data class Task(
    var table: Table?,
    var waiter: Waiter?,
    var content: String?,
    var date: Date?,
    var status: TaskStatus?,
    var type : TaskType?,
var priority: TaskPriority?


) {
}

enum class TaskStatus {
    CUSTOMER,
    KITCHEN,
    DONE,
    CANCELLED
}

enum class TaskPriority {
    HIGH,
    MEDIUM,
    LOW
}
enum class TaskType(val order :Order?) {
   ORDER(null)
}