package com.example.foodiepal_culinarycompanion.model

import java.io.Serializable
import java.time.LocalDate

data class Blog(
    val title: String,
    val time: LocalDate,
    val content: String,
    val writer: String,
    val comments: MutableList<String>
) : Serializable