package org.dsmhackathonbackend.domain.user.exception

import org.dsmhackathonbackend.global.error.ErrorCode
import org.dsmhackathonbackend.global.error.HackathonException

object UserNotFoundException : HackathonException(
    ErrorCode.USER_NOT_FOUND
)
