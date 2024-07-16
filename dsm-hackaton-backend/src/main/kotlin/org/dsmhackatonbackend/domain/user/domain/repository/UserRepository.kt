package org.dsmhackatonbackend.domain.user.domain.repository

import org.dsmhackatonbackend.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

}
