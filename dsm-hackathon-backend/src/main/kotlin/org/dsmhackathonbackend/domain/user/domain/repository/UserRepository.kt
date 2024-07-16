package org.dsmhackathonbackend.domain.user.domain.repository

import org.dsmhackathonbackend.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByAccountId(accountId: String): User?
}
