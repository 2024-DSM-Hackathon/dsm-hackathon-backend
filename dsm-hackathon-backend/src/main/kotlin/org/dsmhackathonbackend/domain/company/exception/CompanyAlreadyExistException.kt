package org.dsmhackathonbackend.domain.company.exception

import org.dsmhackathonbackend.global.error.ErrorCode
import org.dsmhackathonbackend.global.error.HackathonException

object CompanyAlreadyExistException : HackathonException(
    ErrorCode.COMPANY_ALREADY_EXIST
)
