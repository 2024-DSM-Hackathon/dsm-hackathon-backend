package org.dsmhackathonbackend.global.error

class ErrorResponse(
    val status: Int,
    val message: String,
) {

    companion object {
        fun of(e: HackathonException): ErrorResponse {
            return ErrorResponse(
                status = e.status,
                message = e.message
            )
        }
    }
}
