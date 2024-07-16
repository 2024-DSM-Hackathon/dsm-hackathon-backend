package org.dsmhackathonbackend.domain.review.domain

import jakarta.persistence.*
import org.dsmhackathonbackend.domain.company.domain.Company
import org.dsmhackathonbackend.domain.question.domain.Question
import kotlin.math.round

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

    fun update(rating: Int) {
        val totalRating = (this.ratingAverage * this.count) + rating
        this.count += 1
        this.ratingAverage = (round((totalRating / this.count) * 10) / 10)
    }
}
