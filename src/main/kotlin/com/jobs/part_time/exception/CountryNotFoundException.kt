package com.jobs.part_time.exception

import org.springframework.http.HttpStatus

class CountryNotFoundException(countryId: Int) : BaseException(
    HttpStatus.FOUND,
    ApiError(
        errorCode = "COUNTRY_NOT_FOUND",
        description = "Country not found with ID $countryId"
    )
) {
}