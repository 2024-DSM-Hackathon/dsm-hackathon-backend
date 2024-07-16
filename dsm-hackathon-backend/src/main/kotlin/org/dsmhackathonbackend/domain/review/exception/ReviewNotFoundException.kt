package org.dsmhackathonbackend.domain.review.exception

import org.dsmhackathonbackend.global.error.ErrorCode
import org.dsmhackathonbackend.global.error.HackathonException

object ReviewNotFoundException : HackathonException(
    ErrorCode.REVIEW_NOT_FOUND
) {
}
