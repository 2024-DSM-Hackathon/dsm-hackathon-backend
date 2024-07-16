package org.dsmhackathonbackend.domain.question.service

import org.dsmhackathonbackend.domain.question.domain.repository.QuestionRepository
import org.dsmhackathonbackend.domain.question.presentation.dto.response.QuestionResponse
import org.dsmhackathonbackend.domain.question.presentation.dto.response.QuestionResponseList
import org.springframework.stereotype.Service

@Service
class QueryQuestionService(
    private val questionRepository: QuestionRepository
) {

    fun queryQuestionList(): QuestionResponseList {
        val questionList = questionRepository.findAllByOrderByIdAsc()

        return QuestionResponseList(
            questionList = questionList.map {
                QuestionResponse(
                    questionId = it.id,
                    question = it.question
                )
            }
        )
    }
}
