package org.dsmhackathonbackend.domain.company.service

import org.dsmhackathonbackend.domain.company.domain.repository.CompanyRepository
import org.dsmhackathonbackend.domain.company.presentation.dto.response.CompanyResponse
import org.dsmhackathonbackend.domain.company.presentation.dto.response.QueryCompanyRatingAverageResponse
import org.springframework.stereotype.Service

@Service
class QueryCompanyRatingAverageListService(
    private val companyRepository: CompanyRepository
) {

    fun queryCompanyRatingAverage(): QueryCompanyRatingAverageResponse {
        val companies = companyRepository.findAll()

        return QueryCompanyRatingAverageResponse(
            companyLists = companies.map {
                CompanyResponse(
                    company = it.name,
                    rating = it.rating,
                    info = it.info,
                    industrySector = it.industrySector,
                    logo = it.logo
                )
            }
        )
    }
}
