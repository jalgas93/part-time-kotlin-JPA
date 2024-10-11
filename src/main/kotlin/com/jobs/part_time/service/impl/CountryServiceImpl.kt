package com.job.service.impl

import com.job.dto.CountryDto
import com.job.entity.CountryEntity
import com.job.repository.CountryRepository
import com.job.service.CountryService
import com.jobs.part_time.dto.CityDto
import com.jobs.part_time.entity.CityEntity
import com.jobs.part_time.exception.CountryNotFoundException
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
        return countryRepository.findByIdOrNull(id)?.toDto() ?: throw CountryNotFoundException(id)
    }

    override fun search(query: String): List<CountryDto> =
        countryRepository.findByNameStartsWithIgnoreCaseOrderByName(query).map {
            it.toDto()
        }

    override fun create(countryDto: CountryDto): Int {
        return countryRepository.save(countryDto.toEntity()).id
    }

    override fun update(id: Int, countryDto: CountryDto) {
        val existingCountry = countryRepository.findByIdOrNull(id) ?: throw CountryNotFoundException(id)
        existingCountry.name = countryDto.name
        existingCountry.population = countryDto.population

        countryRepository.save(existingCountry)
    }

    override fun delete(id: Int) {
        val existingCountry = countryRepository.findByIdOrNull(id) ?: throw CountryNotFoundException(id)
        countryRepository.deleteById(existingCountry.id)
    }

    private fun CountryEntity.toDto(): CountryDto {
        return CountryDto(
            id = this.id,
            name = this.name,
            population = this.population,
            cities = emptyList(),
           // cities = this.cities.map { it.toDto() }
        )
    }

    private fun CityEntity.toDto(): CityDto =
        CityDto(
            name = this.name,
        )


    private fun CountryDto.toEntity(): CountryEntity {
        return CountryEntity(
            id = 0,
            name = this.name,
            population
        )
    }
}