package com.neonapps.waypointsdk.Models.Menu

import com.neonapps.waypointsdk.Globals
import com.neonapps.waypointsdk.Models.Menu.Question.Question


data class Food(
    var title: String,
    var ingredients: String,
    var imageURL: String?,
    var price: Double,
    var prepDuration: Int,
    var allergens: ArrayList<Allergen>,
    var nutritionFacts: NutritionFacts,
    var questions: ArrayList<Question>,
) {
    val category: Category?
        get() = Globals.arrCategories.firstOrNull { category ->
            category.foods?.any { food ->
                food === this
            } == true
        }
}