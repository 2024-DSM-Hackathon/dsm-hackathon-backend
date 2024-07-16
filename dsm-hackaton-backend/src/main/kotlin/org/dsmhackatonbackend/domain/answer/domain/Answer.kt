package org.dsmhackatonbackend.domain.answer.domain

import jakarta.persistence.*
import org.dsmhackatonbackend.domain.question.domain.Question
import org.dsmhackatonbackend.domain.user.domain.User

@Table(name = "tbl_answer")
@Entity
class Answer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var answer: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    val question: Question
) {
}
