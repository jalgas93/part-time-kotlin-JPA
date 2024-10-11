package com.job.repository

import com.job.entity.CountryEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface CountryRepository : CrudRepository<CountryEntity, Int> {
    fun findByOrderByName(pageable: Pageable): List<CountryEntity>

    fun findByNameStartsWithIgnoreCaseOrderByName(query: String): List<CountryEntity>
}