package org.dsmhackatonbackend.domain.review.domain

import jakarta.persistence.*
import org.dsmhackatonbackend.domain.company.domain.Company
import org.dsmhackatonbackend.domain.question.domain.Question

@Table(name = "tbl_review")
@Entity
class Review(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var count: Int,

    var ratingAverage: Float,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    val company: Company,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    val question: Question
) {
}
