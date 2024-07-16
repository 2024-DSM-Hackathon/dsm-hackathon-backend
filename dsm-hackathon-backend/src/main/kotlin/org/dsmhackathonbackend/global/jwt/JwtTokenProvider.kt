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
    private fun createAccessToken(accountId: String) =
        generateToken(accountId, jwtProperties.accessExp)

    private fun generateToken(userId: String, expiredAt: Long) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setSubject(userId.toString())
            .setHeaderParam("type", "jwt")
            .claim("type", "access")
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()

    fun provideToken(accountId: String) = TokenResponse(
        accessToken = createAccessToken(accountId),
        expiredAt = LocalDateTime.now().plusSeconds(jwtProperties.accessExp)
    )
}
