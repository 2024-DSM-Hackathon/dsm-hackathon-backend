package org.dsmhackathonbackend.domain.auth.controller.dto.request

data class SignUpRequest(
    val name: String,
    val accountId: String,
    val password: String
)
