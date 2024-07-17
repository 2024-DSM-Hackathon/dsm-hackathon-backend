package org.dsmhackathonbackend.domain.company.service

import org.dsmhackathonbackend.domain.company.facade.CompanyFacade
import org.dsmhackathonbackend.domain.company.presentation.dto.response.QueryCompanyDetailsResponse
import org.dsmhackathonbackend.domain.company.presentation.dto.response.RatingResponse
import org.dsmhackathonbackend.domain.question.domain.repository.QuestionRepository
import org.dsmhackathonbackend.domain.question.exception.QuestionNotFoundException
import org.dsmhackathonbackend.domain.review.domain.repository.ReviewRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class QueryMyCompanyDetailsService(
    private val companyFacade: CompanyFacade,
    private val reviewRepository: ReviewRepository,
    private val questionRepository: QuestionRepository
) {

    fun queryMyCompanyDetails(): QueryCompanyDetailsResponse {
        val company = companyFacade.getCurrentCompany()

        val reviewLists = reviewRepository.findAllByCompanyId(company.id)

        return QueryCompanyDetailsResponse(
            company = company.name,
            info = company.info,
            industrySector = company.industrySector,
            logo = company.logo,
            companyRating = company.rating,
            ratingList = reviewLists.map {
                val questionEntity = questionRepository.findByIdOrNull(it.id)
                    ?: throw QuestionNotFoundException

                RatingResponse(
                    question = questionEntity.question,
                    rate = it.ratingAverage
                )
            }
        )
    }
}
