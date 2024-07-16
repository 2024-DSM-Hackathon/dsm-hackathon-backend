package org.dsmhackathonbackend.domain.question.exception

import org.dsmhackathonbackend.global.error.ErrorCode
import org.dsmhackathonbackend.global.error.HackathonException

object QuestionNotFoundException : HackathonException(
    ErrorCode.QUESTION_NOT_FOUND
)
