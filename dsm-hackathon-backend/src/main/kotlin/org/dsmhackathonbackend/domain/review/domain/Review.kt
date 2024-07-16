package org.dsmhackathonbackend.domain.review.domain

import jakarta.persistence.*
import org.dsmhackathonbackend.domain.company.domain.Company
import org.dsmhackathonbackend.domain.question.domain.Question

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
    val question: Question,

    ) {
}
