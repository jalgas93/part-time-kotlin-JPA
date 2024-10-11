package com.job.controller

import com.job.dto.CountryDto
import com.job.service.CountryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/card")
class CountryController(
    private val countryService: CountryService
) {
    @GetMapping("/card")
    fun getAll(@RequestParam("page") pageIndex: Int): List<CountryDto> = countryService.getAll(pageIndex)

    @GetMapping("/hello")
    fun hello(): String =
        "Hello World"

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int): CountryDto = countryService.findById(id)

    @GetMapping("/search")
    fun search(@RequestParam("text") searchText: String): List<CountryDto> = countryService.search(searchText)

    @PostMapping
    fun create(@RequestBody dto: CountryDto): Int {
     return countryService.create(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: CountryDto) {
     countryService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
     countryService.delete(id)
    }
}