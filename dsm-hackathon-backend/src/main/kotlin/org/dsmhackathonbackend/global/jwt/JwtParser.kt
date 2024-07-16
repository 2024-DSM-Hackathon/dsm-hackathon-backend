package org.dsmhackathonbackend.global.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import org.dsmhackathonbackend.global.auth.AuthDetailsService
import org.dsmhackathonbackend.global.exception.ExpiredTokenException
import org.dsmhackathonbackend.global.exception.InternalServerErrorException
import org.dsmhackathonbackend.global.exception.TokenInvalidException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtParser (
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {
    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token)
                .body
        } catch (e: Exception) {
            when(e) {
                is InvalidClaimException -> throw TokenInvalidException
                is ExpiredJwtException -> throw ExpiredTokenException
                else -> throw InternalServerErrorException
            }
        }
    }

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)
        val accountId = claims.subject
        val authDetails = authDetailsService.loadUserByUsername(accountId)

        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

}
