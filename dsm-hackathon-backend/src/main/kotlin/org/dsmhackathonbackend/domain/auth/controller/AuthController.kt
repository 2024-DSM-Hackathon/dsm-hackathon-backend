package org.dsmhackathonbackend.domain.auth.controller

import org.dsmhackathonbackend.domain.auth.controller.dto.request.SignUpRequest
import org.dsmhackathonbackend.domain.auth.service.SignInService
import org.dsmhackathonbackend.domain.auth.service.SignUpService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")

class AuthController(
        private val signUpService : SignUpService,
        private val signInService : SignInService
) {
    @PostMapping("/signup")
    public fun register(@RequestBody request: SignUpRequest){
        signUpService.register(request.accountId,request.password);
    }
    @PostMapping("/signin")
    public fun signIn(accountId:String, password: String){
        signInService.signIn(accountId, password)
    }

}
