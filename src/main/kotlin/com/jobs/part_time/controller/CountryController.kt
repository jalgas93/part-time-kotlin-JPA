package com.job.controller

import com.job.dto.CountryDto
import com.job.service.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

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
}