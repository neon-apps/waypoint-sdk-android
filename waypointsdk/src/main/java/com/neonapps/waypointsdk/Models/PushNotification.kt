package com.neonapps.waypointsdk.Models

import java.util.Date

data class PushNotification(
    var title: String,
    var content: String,
    var isRead: Boolean,
    var date: Date
) {
}