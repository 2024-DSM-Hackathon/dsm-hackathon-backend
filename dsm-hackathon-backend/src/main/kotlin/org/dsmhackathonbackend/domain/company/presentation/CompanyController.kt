package org.dsmhackathonbackend.domain.company.presentation

import org.dsmhackathonbackend.domain.company.presentation.dto.response.QueryCompanyDetailsResponse
import org.dsmhackathonbackend.domain.company.presentation.dto.response.QueryCompanyRatingAverageResponse
import org.dsmhackathonbackend.domain.company.service.QueryCompanyDetailsService
import org.dsmhackathonbackend.domain.company.service.QueryCompanyRatingAverageListService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/company")
@RestController
class CompanyController(
    private val queryCompanyRatingAverageListService: QueryCompanyRatingAverageListService,
    private val queryCompanyDetailsService: QueryCompanyDetailsService
) {

    @GetMapping("/list")
    fun queryCompanyRatingAverage(): QueryCompanyRatingAverageResponse =
        queryCompanyRatingAverageListService.queryCompanyRatingAverage()

    @GetMapping("/{company-id}")
    fun queryCompanyDetails(@PathVariable("company-id") companyId: Long): QueryCompanyDetailsResponse =
        queryCompanyDetailsService.queryCompanyDetails(companyId)


}
