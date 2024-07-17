package org.dsmhackathonbackend.domain.company.service

import org.dsmhackathonbackend.domain.company.domain.Company
import org.dsmhackathonbackend.domain.company.domain.repository.CompanyRepository
import org.dsmhackathonbackend.domain.company.exception.CompanyAlreadyExistException
import org.dsmhackathonbackend.domain.company.presentation.dto.request.CreateCompanyRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CreateCompanyService(
    private val companyRepository: CompanyRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun createCompany(request: CreateCompanyRequest) {
        if (companyRepository.existsByAccountId(request.accountId)) {
            throw CompanyAlreadyExistException
        }

        val company = Company(
            accountId = request.accountId,
            password = passwordEncoder.encode(request.password),
            name = request.name,
            info = request.info,
            rating = 0f,
            registrationNumber = request.registrationNumber,
            industrySector = request.industrySector,
            logo = request.logo
        )

        companyRepository.save(company)
    }
}
