package org.dsmhackathonbackend.domain.company.presentation.dto.request

data class CreateCompanyRequest (
    val logo: String,
    val registrationNumber: String,
    val industrySector: String,
    val name: String,
    val info: String,
    val accountId: String,
    val password: String
)
