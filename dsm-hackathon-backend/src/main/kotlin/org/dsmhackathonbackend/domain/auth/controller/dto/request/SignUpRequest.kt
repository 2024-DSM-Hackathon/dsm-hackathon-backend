package org.dsmhackathonbackend.domain.auth.controller.dto.request

data class SignUpRequest(
        val accountId: String,
        val password: String
)