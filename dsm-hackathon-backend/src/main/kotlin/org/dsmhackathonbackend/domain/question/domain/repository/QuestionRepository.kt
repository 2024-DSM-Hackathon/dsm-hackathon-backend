package org.dsmhackathonbackend.domain.question.domain.repository

import org.dsmhackathonbackend.domain.question.domain.Question
import org.springframework.data.repository.CrudRepository

interface QuestionRepository : CrudRepository<Question, Long> {
    fun findAllByOrderByIdAsc(): List<Question>
}
