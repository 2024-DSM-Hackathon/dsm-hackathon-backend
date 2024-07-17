package org.dsmhackathonbackend.domain.user.presentation

import org.dsmhackathonbackend.domain.user.presentation.dto.response.QueryUserInfoResponse
import org.dsmhackathonbackend.domain.user.service.QueryUserInfoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(
    private val queryUserInfoService: QueryUserInfoService
) {

    @GetMapping("/info")
    fun queryUserInfo(): QueryUserInfoResponse =
        queryUserInfoService.queryUserInfo()

}
