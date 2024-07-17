package org.dsmhackathonbackend.domain.auth.service

import org.dsmhackathonbackend.domain.token.response.TokenResponse
import org.dsmhackathonbackend.domain.user.domain.User
import org.dsmhackathonbackend.domain.user.exception.PasswordMisMatchException
import org.dsmhackathonbackend.domain.user.facade.UserFacade
import org.dsmhackathonbackend.global.jwt.JwtTokenProvider
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignInService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun signIn(accountId: String, password: String): TokenResponse {
        val user = userFacade.getUserByAccountId(accountId)

        if (!passwordEncoder.matches(password, user.password))
            throw PasswordMisMatchException

        return jwtTokenProvider.provideToken(user.accountId)
    }
}
