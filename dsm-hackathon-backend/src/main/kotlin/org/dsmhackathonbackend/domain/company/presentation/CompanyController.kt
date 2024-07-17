package org.dsmhackathonbackend.domain.company.presentation

import org.dsmhackathonbackend.domain.auth.controller.dto.request.SignInRequest
import org.dsmhackathonbackend.domain.company.presentation.dto.request.CreateCompanyRequest
import org.dsmhackathonbackend.domain.company.presentation.dto.response.QueryCompanyDetailsResponse
import org.dsmhackathonbackend.domain.company.presentation.dto.response.QueryCompanyRatingAverageResponse
import org.dsmhackathonbackend.domain.company.service.*
import org.dsmhackathonbackend.domain.token.response.TokenResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/company")
@RestController
class CompanyController(
    private val queryCompanyRatingAverageListService: QueryCompanyRatingAverageListService,
    private val queryCompanyDetailsService: QueryCompanyDetailsService,
    private val createCompanyService: CreateCompanyService,
    private val companySignInService: CompanySignInService,
    private val queryMyCompanyDetailsService: QueryMyCompanyDetailsService
) {

    @GetMapping("/list")
    fun queryCompanyRatingAverage(): QueryCompanyRatingAverageResponse =
        queryCompanyRatingAverageListService.queryCompanyRatingAverage()

    @GetMapping("/{company-id}")
    fun queryCompanyDetails(@PathVariable("company-id") companyId: Long): QueryCompanyDetailsResponse =
        queryCompanyDetailsService.queryCompanyDetails(companyId)

    @PostMapping("/signUp")
    fun createCompany(@RequestBody request: CreateCompanyRequest) {
        createCompanyService.createCompany(request)
    }

    @PostMapping("/signIn")
    fun companySignIn(@RequestBody request: SignInRequest): TokenResponse {
        return  companySignInService.companySignIn(request)
    }

    @GetMapping("/info")
    fun queryMyCompany(): QueryCompanyDetailsResponse =
        queryMyCompanyDetailsService.queryMyCompanyDetails()

}
