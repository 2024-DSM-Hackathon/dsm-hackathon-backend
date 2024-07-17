package org.dsmhackathonbackend.domain.auth.controller.dto.request

data class SignInRequest (
    val accountId: String,
    val password: String
)
