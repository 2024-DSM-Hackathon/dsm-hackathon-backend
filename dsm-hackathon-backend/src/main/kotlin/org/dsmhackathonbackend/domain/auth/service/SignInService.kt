package org.dsmhackathonbackend.domain.auth.service

import org.dsmhackathonbackend.domain.user.domain.User
import org.dsmhackathonbackend.domain.user.facade.UserFacade
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

class SignInService(
        private val authenticationManager: AuthenticationManager,
        private val userFacade: UserFacade
) {
    public fun signIn(accountId:String, password:String){
        val user:User = userFacade.getCurrentUser();
    }
    fun login(accountId: String, password: String): String {

        val authentication: Authentication? = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(accountId, password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        return generateToken(accountId)
    }

    fun getCurrentUser(): User {
        return userFacade.getCurrentUser()
    }

    private fun generateToken(accountId: String): String {
        // 토큰 생성 로직 추가
        // 여기서는 단순히 accountId를 반환하지만, 실제로는 JWT 등을 사용하여 토큰을 생성해야 합니다.
        return accountId
    }

    private fun getUsernameFromToken(token: String): String {
        // 토큰에서 사용자명을 추출하는 로직 추가
        return token
    }
}