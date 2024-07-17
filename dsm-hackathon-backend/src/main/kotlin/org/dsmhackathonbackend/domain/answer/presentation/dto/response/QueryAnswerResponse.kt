package org.dsmhackathonbackend.domain.answer.presentation.dto.response

import java.util.Date


data class QueryAnswerListResponse(
    val answerList: List<QueryAnswerResponse>
)

data class QueryAnswerResponse (
    val question: String,
    val sector: String,
    val annual: Int,
    val status: String,
    val answer: String,
    val rating: Int,
    val date: Date
)
