package org.dsmhackathonbackend.domain.user.facade

import org.dsmhackathonbackend.domain.user.domain.User
import org.dsmhackathonbackend.domain.user.domain.repository.UserRepository
import org.dsmhackathonbackend.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository,
) {

    fun getCurrentUser(): User {
        val accountId = SecurityContextHolder.getContext().authentication.name
        return getUserByAccountId(accountId)
    }

    fun getUserByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
    }
}
