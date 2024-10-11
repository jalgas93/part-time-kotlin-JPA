package com.job.dto

import com.jobs.part_time.dto.CityDto

data class CountryDto(
    val id: Int? = null,
    val name: String,
    val population: Int,
    var cities: List<CityDto>
)