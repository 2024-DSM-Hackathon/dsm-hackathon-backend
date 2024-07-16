package org.dsmhackathonbackend.domain.question.presentation.dto.response

data class QuestionResponseList (
    val questionList: List<QuestionResponse>
)

data class QuestionResponse(
    val questionId: Long,
    val question: String
)
