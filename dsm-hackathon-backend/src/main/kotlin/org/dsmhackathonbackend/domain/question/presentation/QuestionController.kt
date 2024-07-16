package org.dsmhackathonbackend.domain.question.presentation

import org.dsmhackathonbackend.domain.question.presentation.dto.response.QuestionResponseList
import org.dsmhackathonbackend.domain.question.service.QueryQuestionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/question")
@RestController
class QuestionController(
    private val queryQuestionService: QueryQuestionService
) {

    @GetMapping("/")
    fun queryQuestion(): QuestionResponseList =
        queryQuestionService.queryQuestionList()

}
