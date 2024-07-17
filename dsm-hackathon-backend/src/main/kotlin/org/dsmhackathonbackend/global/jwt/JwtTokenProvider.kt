package org.dsmhackathonbackend.global.jwt

import io.jsonwebtoken.*
import org.dsmhackathonbackend.domain.token.response.TokenResponse
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
) {
    private fun createAccessToken(accountId: String, type: String) =
        generateToken(accountId, type, jwtProperties.accessExp)

    private fun generateToken(userId: String, type: String, expiredAt: Long) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setSubject(userId.toString())
            .setHeaderParam("type", "jwt")
            .claim("type", "access")
            .claim("auth", type)
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()

    fun provideToken(accountId: String, type: String) = TokenResponse(
        accessToken = createAccessToken(accountId, type),
        expiredAt = LocalDateTime.now().plusSeconds(jwtProperties.accessExp)
    )
}
