package org.dsmhackathonbackend.domain.company.facade

import org.dsmhackathonbackend.domain.company.domain.Company
import org.dsmhackathonbackend.domain.company.domain.repository.CompanyRepository
import org.dsmhackathonbackend.domain.company.exception.CompanyNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class CompanyFacade(
    private val companyRepository: CompanyRepository
) {

    fun getCurrentCompany(): Company {
        val accountId = SecurityContextHolder.getContext().authentication.name
        return getCompanyByAccountId(accountId)
    }

    fun getCompanyByAccountId(accountId: String): Company {
        return companyRepository.findByAccountId(accountId)
            ?: throw CompanyNotFoundException
    }
}
