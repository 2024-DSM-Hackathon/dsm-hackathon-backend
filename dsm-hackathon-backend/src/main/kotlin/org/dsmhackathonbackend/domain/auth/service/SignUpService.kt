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
class SingUpService(
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

    fun authenticate(username: String, password: String): String {
        val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(username, password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        return generateToken(username)
    }

    fun authorize(token: String): Boolean {
        val username = getUsernameFromToken(token)
        val userDetails = authDetailsService.loadUserByUsername(username) as AuthDetails
        return userDetails != null
    }

    private fun generateToken(username: String): String {
        // 토큰 생성 로직 추가
        return username
    }

    private fun getUsernameFromToken(token: String): String {
        // 토큰에서 사용자명 추출 로직 추가
        return token
    }
}
