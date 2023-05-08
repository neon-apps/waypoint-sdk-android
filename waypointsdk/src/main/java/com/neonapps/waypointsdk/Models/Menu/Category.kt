package com.neonapps.waypointsdk.Models.Menu



 class Category(
    var title: String,
    var description: String,
    var image: Int,
    var foods: List<Food>?,
    var type: KitchenType,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        other as Category

        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        return title.hashCode()
    }
}