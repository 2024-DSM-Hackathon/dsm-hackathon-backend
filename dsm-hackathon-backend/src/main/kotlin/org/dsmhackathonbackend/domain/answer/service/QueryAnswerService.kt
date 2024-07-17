package org.dsmhackathonbackend.domain.answer.service

import org.dsmhackathonbackend.domain.answer.domain.repository.AnswerRepository
import org.dsmhackathonbackend.domain.answer.presentation.dto.response.QueryAnswerListResponse
import org.dsmhackathonbackend.domain.answer.presentation.dto.response.QueryAnswerResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class QueryAnswerService(
    private val answerRepository: AnswerRepository,
    private val questionRepository: AnswerRepository
) {

    fun queryAnswer(companyId: Long): QueryAnswerListResponse {
        val answerList = answerRepository.findAllByCompanyIdOrderByDateDesc(companyId)

        return QueryAnswerListResponse(
            answerList = answerList.map {
                QueryAnswerResponse(
                    question = it.question.question,
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
