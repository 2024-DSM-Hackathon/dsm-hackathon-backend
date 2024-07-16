package org.dsmhackathonbackend.domain.answer.domain.repository

import org.dsmhackathonbackend.domain.answer.domain.Answer
import org.springframework.data.repository.CrudRepository

interface AnswerRepository : CrudRepository<Answer, Long> {
}
