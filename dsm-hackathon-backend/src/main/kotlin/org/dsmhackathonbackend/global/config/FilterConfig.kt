package org.dsmhackathonbackend.global.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.dsmhackathonbackend.global.error.ExceptionFilter
import org.dsmhackathonbackend.global.jwt.JwtParser
import org.dsmhackathonbackend.global.jwt.JwtTokenFilter
import org.dsmhackathonbackend.global.jwt.JwtTokenProvider
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.SecurityConfigurer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class FilterConfig(
    private val jwtParser: JwtParser,
    private val objectMapper: ObjectMapper
) : SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity> {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtTokenFilter(jwtParser), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(ExceptionFilter(objectMapper), JwtTokenFilter::class.java)
    }

    override fun init(builder: HttpSecurity?) {}
}
