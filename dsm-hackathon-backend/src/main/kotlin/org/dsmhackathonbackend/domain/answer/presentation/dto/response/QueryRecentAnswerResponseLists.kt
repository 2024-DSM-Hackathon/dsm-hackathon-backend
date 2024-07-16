package org.dsmhackathonbackend.domain.answer.presentation.dto.response

import java.util.Date

data class QueryRecentReviewResponseLists (
    val reviewList: List<AnswerResponse>
)

data class AnswerResponse(
    val userName: String,
    val company: String,
    val annual: Int,
    val status: String,
    val answer: String,
    val rating: Int,
    val date: Date
)
