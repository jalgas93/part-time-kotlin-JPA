package com.job.service.impl

import com.job.dto.CountryDto
import com.job.entity.CountryEntity
import com.job.repository.CountryRepository
import com.job.service.CountryService
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl(
    val countryRepository: CountryRepository
) : CountryService {
    override fun getAll(pageIndex: Int): List<CountryDto> {

        return countryRepository.findByOrderByName(PageRequest.of(pageIndex, 2)).map {
            it.toDto()
        }
    }

    override fun findById(id: Int): CountryDto {
        return countryRepository.findByIdOrNull(id)?.toDto() ?: throw RuntimeException("Not found")
    }

    override fun search(query: String): List<CountryDto> =
        countryRepository.findByNameStartsWithOrderByName(query).map {
            it.toDto()
        }

    private fun CountryEntity.toDto(): CountryDto {
        return CountryDto(
            id = this.id,
            owner = this.owner,
            cardTitle = this.cardTitle,
            cardDescription = this.cardDescription,
            cardDate = this.cardDate,
            cardType = this.cardType,
            isVerified = this.isVerified,
        )
    }
}