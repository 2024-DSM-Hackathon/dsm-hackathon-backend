package org.dsmhackathonbackend.domain.answer.domain

import jakarta.persistence.*
import org.apache.logging.log4j.util.StringMap
import org.dsmhackathonbackend.domain.question.domain.Question
import org.dsmhackathonbackend.domain.user.domain.User

@Table(name = "tbl_answer")
@Entity
class Answer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var answer: String,

    val sector: String,

    val annual: Int,

    val status: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    val question: Question
) {
}
