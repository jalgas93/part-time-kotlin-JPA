package com.job.dto

data class CountryDto(
    val id: Int? = null,
    var owner: Int,
    var cardTitle: String,
    var cardDescription: String,
    var cardDate: String,
    var cardType: String,
    var isVerified: Boolean = false,
)