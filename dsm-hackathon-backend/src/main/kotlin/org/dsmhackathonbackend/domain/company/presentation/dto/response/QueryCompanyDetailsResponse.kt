package org.dsmhackathonbackend.domain.company.presentation.dto.response

data class QueryCompanyDetailsResponse (
    val companyId: Long,
    val company: String,
    val info: String,
    val industrySector: String,
    val logo: String,
    val companyRating: Float,
    val registrationNumber: String,
    val ratingList: List<RatingResponse>
)

data class RatingResponse(
    val question: String,
    val rate: Float
)
