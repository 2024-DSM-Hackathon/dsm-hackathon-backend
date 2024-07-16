package org.dsmhackathonbackend.domain.company.presentation.dto.response

data class QueryCompanyRatingAverageResponse(
    val companyLists: List<CompanyResponse>
)

data class CompanyResponse (
    val companyId: Long,
    val company: String,
    val rating: Float,
    val info: String,
    val industrySector: String,
    val logo: String
)
