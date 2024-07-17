package org.dsmhackathonbackend.domain.company.domain

import jakarta.persistence.*
import kotlin.math.round

@Table(name = "tbl_company")
@Entity
class Company(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val accountId: String,

    val password: String,

    val name: String,

    var info: String,

    var rating: Float,

    val registrationNumber: String,

    val industrySector: String,

    val logo: String
) {

    fun update(totalRating: Float) {
        this.rating = (round((totalRating / 4) * 10) / 10)
    }
}
