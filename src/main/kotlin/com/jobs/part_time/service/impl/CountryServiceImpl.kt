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
        countryRepository.findByNameStartsWithIgnoreCaseOrderByName(query).map {
            it.toDto()
        }

    override fun create(countryDto: CountryDto): Int {
        return countryRepository.save(countryDto.toEntity()).id
    }

    override fun update(id: Int, countryDto: CountryDto) {
        val existingCountry = countryRepository.findByIdOrNull(id) ?: throw RuntimeException("Not found")
        existingCountry.owner = countryDto.owner
        existingCountry.cardDate = countryDto.cardDate
        existingCountry.cardType = countryDto.cardType
        existingCountry.cardTitle = countryDto.cardTitle
        existingCountry.cardDescription = countryDto.cardDescription
        existingCountry.isVerified = countryDto.isVerified

        countryRepository.save(existingCountry)
    }

    override fun delete(id: Int) {
        val existingCountry = countryRepository.findByIdOrNull(id) ?: throw RuntimeException("Not found")
        countryRepository.deleteById(existingCountry.id)
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

    private fun CountryDto.toEntity(): CountryEntity {
        return CountryEntity(
            id = 0,
            owner = this.owner,
            cardTitle = this.cardTitle,
            cardDescription = this.cardDescription,
            cardDate = this.cardDate,
            cardType = this.cardType,
        )
    }
}