package org.dsmhackathonbackend.global.error

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    TOKEN_EXPIRED(401, "Token Expired"),
    TOKEN_INVALID(401, "Token Invalid"),

    USER_NOT_FOUND(404, "User not found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}
