package org.dsmhackathonbackend.domain.auth.service

import org.dsmhackathonbackend.domain.auth.controller.dto.request.SignUpRequest
import org.dsmhackathonbackend.domain.user.domain.User
import org.dsmhackathonbackend.domain.user.domain.repository.UserRepository
import org.dsmhackathonbackend.domain.user.exception.UserAlreadyExistException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,

    ) {
    fun register(request: SignUpRequest) {

        if (userRepository.existsByAccountId(request.accountId)) {
            throw UserAlreadyExistException
        }

        val user = User(
            accountId = request.accountId,
            password = passwordEncoder.encode(request.password),
            name = request.name
        )
        userRepository.save(user)
    }
}
