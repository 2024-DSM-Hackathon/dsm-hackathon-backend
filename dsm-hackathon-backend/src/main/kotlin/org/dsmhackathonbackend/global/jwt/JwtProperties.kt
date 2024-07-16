package org.dsmhackathonbackend.global.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
data class JwtProperties (
    var secretKey: String,
    val accessExp: Long,
)
