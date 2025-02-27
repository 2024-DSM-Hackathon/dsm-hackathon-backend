package org.dsmhackathonbackend.global.auth

import org.dsmhackathonbackend.domain.user.domain.repository.UserRepository
import org.dsmhackathonbackend.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByAccountId(username)
            ?: throw UserNotFoundException
        return AuthDetails(user)
    }
}
