package org.dsmhackathonbackend.domain.user.domain

import jakarta.persistence.*

@Table(name = "tbl_user")
@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val accountId: String,

    val password: String,

    val name: String
) {
}
