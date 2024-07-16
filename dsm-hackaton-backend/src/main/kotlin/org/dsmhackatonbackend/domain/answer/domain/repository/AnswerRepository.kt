package org.dsmhackatonbackend.domain.answer.domain.repository

import org.dsmhackatonbackend.domain.answer.domain.Answer
import org.springframework.data.repository.CrudRepository

interface AnswerRepository : CrudRepository<Answer, Long> {
}
