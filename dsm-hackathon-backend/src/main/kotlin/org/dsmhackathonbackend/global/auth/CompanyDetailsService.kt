package org.dsmhackathonbackend.global.auth

import org.dsmhackathonbackend.domain.company.domain.repository.CompanyRepository
import org.dsmhackathonbackend.domain.company.exception.CompanyNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class CompanyDetailsService(
    private val companyRepository: CompanyRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val company = companyRepository.findByAccountId(username)
            ?: throw CompanyNotFoundException
        return CompanyDetails(company)
    }
}
