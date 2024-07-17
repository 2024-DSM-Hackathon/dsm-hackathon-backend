package org.dsmhackathonbackend.domain.user.exception

import org.dsmhackathonbackend.global.error.ErrorCode
import org.dsmhackathonbackend.global.error.HackathonException

object UserAlreadyExistException : HackathonException(
    ErrorCode.USER_ALREADY_EXIST
)
