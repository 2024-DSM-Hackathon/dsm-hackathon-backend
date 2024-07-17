package org.dsmhackathonbackend.domain.user.presentation.dto.response

import java.util.Date

data class QueryUserInfoResponse (
    val name: String,
    val review: List<ReviewList>
)

data class ReviewList(
    val sector: String,
    val annual: Int,
    val status: String,
    val answer: String,
    val rating: Int,
    val date: Date
)
