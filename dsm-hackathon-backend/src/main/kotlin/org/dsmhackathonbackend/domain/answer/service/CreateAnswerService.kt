package org.dsmhackathonbackend.domain.answer.service

import jakarta.transaction.Transactional
import org.dsmhackathonbackend.domain.answer.domain.Answer
import org.dsmhackathonbackend.domain.answer.domain.repository.AnswerRepository
import org.dsmhackathonbackend.domain.answer.presentation.dto.request.CreateAnswerRequest
import org.dsmhackathonbackend.domain.company.domain.repository.CompanyRepository
import org.dsmhackathonbackend.domain.company.exception.CompanyNotFoundException
import org.dsmhackathonbackend.domain.question.domain.repository.QuestionRepository
import org.dsmhackathonbackend.domain.question.exception.QuestionNotFoundException
import org.dsmhackathonbackend.domain.review.domain.repository.ReviewRepository
import org.dsmhackathonbackend.domain.review.exception.ReviewNotFoundException
import org.dsmhackathonbackend.domain.user.facade.UserFacade
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

@Service
class CreateAnswerService(
    private val answerRepository: AnswerRepository,
    private val userFacade: UserFacade,
    private val companyRepository: CompanyRepository,
    private val questionRepository: QuestionRepository,
    private val reviewRepository: ReviewRepository
) {

    @Transactional
    fun createAnswer(request: CreateAnswerRequest) {
        val companyEntity = companyRepository.findByIdOrNull(request.companyId)
            ?: throw CompanyNotFoundException

        val userEntity = userFacade.getCurrentUser()

        val answerEntityList = request.answerList.map {
            val questionEntity = questionRepository.findByIdOrNull(it.questionId)
                ?: throw QuestionNotFoundException

            val reviewEntity = reviewRepository.findByCompanyAndQuestion(companyEntity, questionEntity)
                ?: throw ReviewNotFoundException

            reviewEntity.update(it.rating)

            Answer(
                answer = it.answer,
                sector = request.sector,
                annual = request.annual,
                status = request.status,
                date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                rating = it.rating,
                user = userEntity,
                question = questionEntity,
                company = companyEntity
            )
        }

        answerRepository.saveAll(answerEntityList)
    }
}
