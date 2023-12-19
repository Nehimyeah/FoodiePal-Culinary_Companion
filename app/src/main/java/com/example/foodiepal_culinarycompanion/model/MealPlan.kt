package com.example.foodiepal_culinarycompanion.model

data class MealPlan(
    val title: String,
    val ingredients: List<String>,
    val instruction: String
)