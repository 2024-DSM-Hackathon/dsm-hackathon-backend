package org.dsmhackathonbackend.domain.answer.domain

import jakarta.persistence.*
import org.apache.logging.log4j.util.StringMap
import org.dsmhackathonbackend.domain.company.domain.Company
import org.dsmhackathonbackend.domain.question.domain.Question
import org.dsmhackathonbackend.domain.user.domain.User
import java.util.*

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

    val date: Date,

    val rating: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    val question: Question,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    val company: Company
) {
}
