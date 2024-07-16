package org.dsmhackathonbackend.domain.answer.presentation

import org.dsmhackathonbackend.domain.answer.presentation.dto.request.CreateAnswerRequest
import org.dsmhackathonbackend.domain.answer.presentation.dto.response.QueryAnswerListResponse
import org.dsmhackathonbackend.domain.answer.presentation.dto.response.QueryRecentReviewResponseLists
import org.dsmhackathonbackend.domain.answer.service.CreateAnswerService
import org.dsmhackathonbackend.domain.answer.service.QueryAnswerService
import org.dsmhackathonbackend.domain.answer.service.QueryRecentAnswerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/answer")
@RestController
class AnswerController(
    private val queryRecentAnswerService: QueryRecentAnswerService,
    private val createAnswerService: CreateAnswerService,
    private val queryAnswerService: QueryAnswerService
) {

    @GetMapping("/recent")
    fun queryRecentAnswer(): QueryRecentReviewResponseLists =
        queryRecentAnswerService.queryRecentReview()

    @PostMapping("/create")
    fun createAnswer(@RequestBody request: CreateAnswerRequest) {
        createAnswerService.createAnswer(request)
    }

    @GetMapping("/{company-id}")
    fun queryAnswer(@PathVariable("company-id") companyId: Long): QueryAnswerListResponse =
        queryAnswerService.queryAnswer(companyId)

}
