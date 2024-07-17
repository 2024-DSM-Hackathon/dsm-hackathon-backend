package org.dsmhackathonbackend.domain.company.service

import org.dsmhackathonbackend.domain.auth.controller.dto.request.SignInRequest
import org.dsmhackathonbackend.domain.company.domain.repository.CompanyRepository
import org.dsmhackathonbackend.domain.company.exception.CompanyNotFoundException
import org.dsmhackathonbackend.domain.token.response.TokenResponse
import org.dsmhackathonbackend.domain.user.exception.PasswordMisMatchException
import org.dsmhackathonbackend.global.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CompanySignInService(
    private val companyRepository: CompanyRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {

    fun companySignIn(request: SignInRequest): TokenResponse {
        val company = companyRepository.findByAccountId(request.accountId)
            ?: throw CompanyNotFoundException

        if (!passwordEncoder.matches(request.password, company.password))
            throw PasswordMisMatchException

        return jwtTokenProvider.provideToken(company.accountId, "company")
    }
}
