package com.example.foodiepal_culinarycompanion.model

import java.io.Serializable

data class Recipe(
    var image: Int,
    var cookingTime: String,
    var rating: Int,
    var title: String,
    var description: String
) : Serializable