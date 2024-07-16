package org.dsmhackathonbackend.domain.question.domain

import jakarta.persistence.*

@Table(name = "tbl_question")
@Entity
class Question(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val question: String
) {
}
