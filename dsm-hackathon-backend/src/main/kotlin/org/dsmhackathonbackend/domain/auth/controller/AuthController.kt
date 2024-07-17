package org.dsmhackathonbackend.domain.auth.controller

import org.dsmhackathonbackend.domain.auth.controller.dto.request.SignInRequest
import org.dsmhackathonbackend.domain.auth.controller.dto.request.SignUpRequest
import org.dsmhackathonbackend.domain.auth.service.SignInService
import org.dsmhackathonbackend.domain.auth.service.SignUpService
import org.dsmhackathonbackend.domain.token.response.TokenResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class AuthController(
    private val signUpService: SignUpService,
    private val signInService: SignInService
) {
    @PostMapping("/signUp")
    fun register(@RequestBody request: SignUpRequest) {
        signUpService.register(request);
    }

    @PostMapping("/signIn")
    fun signIn(@RequestBody request: SignInRequest): TokenResponse =
        signInService.signIn(request.accountId, request.password)

}
