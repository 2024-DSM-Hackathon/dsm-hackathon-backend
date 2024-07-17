package org.dsmhackathonbackend.domain.company.service

import org.dsmhackathonbackend.domain.company.domain.repository.CompanyRepository
import org.dsmhackathonbackend.domain.company.exception.CompanyNotFoundException
import org.dsmhackathonbackend.domain.company.presentation.dto.response.QueryCompanyDetailsResponse
import org.dsmhackathonbackend.domain.company.presentation.dto.response.RatingResponse
import org.dsmhackathonbackend.domain.question.domain.repository.QuestionRepository
import org.dsmhackathonbackend.domain.question.exception.QuestionNotFoundException
import org.dsmhackathonbackend.domain.review.domain.repository.ReviewRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class QueryCompanyDetailsService(
    private val companyRepository: CompanyRepository,
    private val reviewRepository: ReviewRepository,
    private val questionRepository: QuestionRepository
) {

    fun queryCompanyDetails(companyId: Long): QueryCompanyDetailsResponse {
        val companyEntity = companyRepository.findByIdOrNull(companyId)
            ?: throw CompanyNotFoundException

        val reviewLists = reviewRepository.findAllByCompanyId(companyId)

        return QueryCompanyDetailsResponse(
            companyId = companyEntity.id,
            company = companyEntity.name,
            info = companyEntity.info,
            industrySector = companyEntity.industrySector,
            logo = companyEntity.logo,
            companyRating = companyEntity.rating,
            registrationNumber = companyEntity.registrationNumber,
            ratingList = reviewLists.map {
                val questionEntity = questionRepository.findByIdOrNull(it.question.id)
                    ?: throw QuestionNotFoundException

                RatingResponse(
                    question = questionEntity.question,
                    rate = it.ratingAverage
                )
            }
        )
    }
}
