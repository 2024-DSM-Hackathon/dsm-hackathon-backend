package org.dsmhackathonbackend.global.error

abstract class HackathonException(
    val errorCode: ErrorCode
) : RuntimeException() {

    val status: Int get() = errorCode.status
    override val message: String get() = errorCode.message
}
