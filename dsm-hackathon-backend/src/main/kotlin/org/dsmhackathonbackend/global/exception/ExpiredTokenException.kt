package org.dsmhackathonbackend.global.exception

import org.dsmhackathonbackend.global.error.ErrorCode
import org.dsmhackathonbackend.global.error.HackathonException

object ExpiredTokenException : HackathonException(
    ErrorCode.TOKEN_EXPIRED
)
