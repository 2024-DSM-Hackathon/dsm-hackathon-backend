package org.dsmhackathonbackend.domain.answer.presentation.dto.request

data class CreateAnswerRequest(
    val companyId: Long,
    val sector: String,
    val annual: Int,
    val status: String,
    val answerList: List<AnswerRequest>
)

data class AnswerRequest(
    val questionId: Long,
    val answer: String,
    val rating: Int
)
