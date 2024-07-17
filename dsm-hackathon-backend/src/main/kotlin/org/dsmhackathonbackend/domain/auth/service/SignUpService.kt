package org.dsmhackathonbackend.domain.auth.service

import org.dsmhackathonbackend.domain.user.domain.User
import org.dsmhackathonbackend.domain.user.domain.repository.UserRepository
import org.dsmhackathonbackend.global.auth.AuthDetails
import org.dsmhackathonbackend.global.auth.AuthDetailsService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignUpService(
        private val authDetailsService: AuthDetailsService,
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
        private val authenticationManager: AuthenticationManager

) {
    private val name:String="user";
    fun register(accountId: String, password: String) {

        val userOptional = userRepository.findByAccountId(accountId)
        if (userOptional!=null) {
            throw IllegalStateException("Username already taken")
        }

        val encodedPassword = passwordEncoder.encode(password)

        val user = User(
                accountId = accountId,
                password = encodedPassword,
                name = name
        )
        userRepository.save(user)
    }
}
