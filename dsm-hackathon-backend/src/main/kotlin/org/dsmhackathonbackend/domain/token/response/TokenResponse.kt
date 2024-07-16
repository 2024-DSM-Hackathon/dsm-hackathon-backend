package org.dsmhackathonbackend.domain.token.response

import java.time.LocalDateTime

data class TokenResponse (
    val accessToken: String,
    val expiredAt: LocalDateTime,
)
