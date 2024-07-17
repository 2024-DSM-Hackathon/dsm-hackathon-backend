package org.dsmhackathonbackend.domain.user.exception

import org.dsmhackathonbackend.global.error.ErrorCode
import org.dsmhackathonbackend.global.error.HackathonException

object PasswordMisMatchException : HackathonException(
    ErrorCode.PASSWORD_MISMATCHED
)
