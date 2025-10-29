package com.anindya.bottomnavigation.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val notes: String,
    val status: Boolean
)
