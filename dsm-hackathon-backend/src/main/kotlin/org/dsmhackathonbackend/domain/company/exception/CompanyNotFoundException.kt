package org.dsmhackathonbackend.domain.company.exception

import org.dsmhackathonbackend.global.error.ErrorCode
import org.dsmhackathonbackend.global.error.HackathonException

object CompanyNotFoundException : HackathonException(
    ErrorCode.COMPANY_NOT_FOUND
)
