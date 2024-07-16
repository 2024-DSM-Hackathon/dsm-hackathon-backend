package org.dsmhackathonbackend.domain.review.domain.repository

import org.dsmhackathonbackend.domain.company.domain.Company
import org.dsmhackathonbackend.domain.question.domain.Question
import org.dsmhackathonbackend.domain.review.domain.Review
import org.springframework.data.repository.CrudRepository

interface ReviewRepository : CrudRepository<Review, Long> {
    fun findByCompanyAndQuestion(company: Company, question: Question): Review?
    fun findAllByCompanyId(companyId: Long): List<Review>
}
