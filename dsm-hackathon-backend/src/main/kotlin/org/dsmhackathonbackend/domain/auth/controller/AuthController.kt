package org.dsmhackathonbackend.domain.auth.controller

import org.dsmhackathonbackend.domain.auth.service.SignInService
import org.dsmhackathonbackend.domain.auth.service.SingUpService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")

class AuthController(
        private val signUpService : SingUpService,
        private val signInService : SignInService
) {
    @PostMapping("/signup")
    public fun register(accountId:String, password:String){
        signUpService.register(accountId,password);
    }
    @PostMapping("/signin")
    public fun signIn(accountId:String, password: String){
        signInService.signIn(accountId, password)
    }

}
