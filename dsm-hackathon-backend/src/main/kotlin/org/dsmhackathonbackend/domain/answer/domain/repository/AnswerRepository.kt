package org.dsmhackathonbackend.domain.answer.domain.repository

import org.dsmhackathonbackend.domain.answer.domain.Answer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface AnswerRepository : CrudRepository<Answer, Long> {
    fun findAllByOrderByDateDesc(pageable: Pageable): Page<Answer>
    fun findAllByCompanyIdOrderByDateDesc(companyId: Long): List<Answer>
    fun findAllByUserIdOrderByDateDesc(userId: Long): List<Answer>
}
