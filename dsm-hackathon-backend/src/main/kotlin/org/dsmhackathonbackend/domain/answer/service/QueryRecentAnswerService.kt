package org.dsmhackathonbackend.domain.answer.service

import org.dsmhackathonbackend.domain.answer.domain.repository.AnswerRepository
import org.dsmhackathonbackend.domain.answer.presentation.dto.response.AnswerResponse
import org.dsmhackathonbackend.domain.answer.presentation.dto.response.QueryRecentReviewResponseLists
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class QueryRecentAnswerService(
    private val answerRepository: AnswerRepository
) {

    fun queryRecentReview(): QueryRecentReviewResponseLists {
        val pageable = PageRequest.of(0, 3)
        val answers = answerRepository.findAllByOrderByDateDesc(pageable)

        return QueryRecentReviewResponseLists(
            reviewList = answers.content.map {
                AnswerResponse(
                    userName = it.user.name,
                    company = it.company.name,
                    annual = it.annual,
                    status = it.status,
                    answer = it.answer,
                    rating = it.rating,
                    date = it.date
                )
            }
        )
    }
}
