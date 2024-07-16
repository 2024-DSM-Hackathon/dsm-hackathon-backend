package org.dsmhackathonbackend.global.error

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    TOKEN_EXPIRED(401, "Token Expired"),
    TOKEN_INVALID(401, "Token Invalid"),

    USER_NOT_FOUND(404, "User Not Found"),
    COMPANY_NOT_FOUND(404, "Company Not Found"),
    QUESTION_NOT_FOUND(404, "Question Not Found"),
    REVIEW_NOT_FOUND(404, "Review Not Found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}
