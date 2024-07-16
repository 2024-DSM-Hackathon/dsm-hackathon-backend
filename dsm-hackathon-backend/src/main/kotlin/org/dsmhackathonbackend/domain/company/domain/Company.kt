package org.dsmhackathonbackend.domain.company.domain

import jakarta.persistence.*

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

    var rating: Int,

    val registrationNumber: Int,

    val industrySector: String,

    val logo: String
) {
}
