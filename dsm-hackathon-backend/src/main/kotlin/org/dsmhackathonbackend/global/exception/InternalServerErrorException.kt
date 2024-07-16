package org.dsmhackathonbackend.global.exception

import org.dsmhackathonbackend.global.error.ErrorCode
import org.dsmhackathonbackend.global.error.HackathonException

object InternalServerErrorException : HackathonException(
    ErrorCode.INTERNAL_SERVER_ERROR
)
