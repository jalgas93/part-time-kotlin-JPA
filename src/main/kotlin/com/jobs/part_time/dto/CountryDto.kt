package com.job.dto

data class CountryDto(
    val id: Int,
    val owner: Int,
    val cardTitle: String,
    val cardDescription: String,
    val cardDate: String,
    val cardType: String,
    val isVerified: Boolean = false,
)