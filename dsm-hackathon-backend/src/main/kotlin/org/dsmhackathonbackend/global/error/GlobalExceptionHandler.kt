package org.dsmhackathonbackend.global.error

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(HackathonException::class)
    fun customExceptionHandling(e: HackathonException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse.of(e), HttpStatus.valueOf(e.status))
    }

    @ExceptionHandler(BindException::class)
    fun handleBindException(e: BindException): ResponseEntity<*>? {
        val errorMap: MutableMap<String, String?> = HashMap()
        for (error in e.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
        }
        return ResponseEntity<Map<String, String?>>(errorMap, BAD_REQUEST)
    }
}
