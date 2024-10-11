package com.job.service

import com.job.dto.CountryDto

interface CountryService {
    fun getAll(pageIndex:Int): List<CountryDto>

    fun findById(id: Int): CountryDto

    fun search(query: String): List<CountryDto>
}