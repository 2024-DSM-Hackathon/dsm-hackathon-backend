package org.dsmhackathonbackend.domain.user.service

import org.dsmhackathonbackend.domain.answer.domain.repository.AnswerRepository
import org.dsmhackathonbackend.domain.user.facade.UserFacade
import org.dsmhackathonbackend.domain.user.presentation.dto.response.QueryUserInfoResponse
import org.dsmhackathonbackend.domain.user.presentation.dto.response.ReviewList
import org.springframework.stereotype.Service

@Service
class QueryUserInfoService(
    private val userFacade: UserFacade,
    private val answerRepository: AnswerRepository
) {

    fun queryUserInfo(): QueryUserInfoResponse {
        val user = userFacade.getCurrentUser()

        val answerList = answerRepository.findAllByUserIdOrderByDateDesc(user.id)

        return QueryUserInfoResponse(
            name = user.name,
            review = answerList.map {
                ReviewList(
                    sector = it.sector,
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
