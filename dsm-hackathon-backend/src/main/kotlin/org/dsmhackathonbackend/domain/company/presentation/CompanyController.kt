package org.dsmhackathonbackend.domain.company.presentation

import org.dsmhackathonbackend.domain.company.presentation.dto.response.QueryCompanyRatingAverageResponse
import org.dsmhackathonbackend.domain.company.service.QueryCompanyRatingAverageListService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/company")
@RestController
class CompanyController(
    private val queryCompanyRatingAverageListService: QueryCompanyRatingAverageListService
) {

    @GetMapping("/")
    fun queryCompanyRatingAverage(): QueryCompanyRatingAverageResponse =
        queryCompanyRatingAverageListService.queryCompanyRatingAverage()

}
