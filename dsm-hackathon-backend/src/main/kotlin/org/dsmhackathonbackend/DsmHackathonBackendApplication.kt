package org.dsmhackathonbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class DsmHackathonBackendApplication

fun main(args: Array<String>) {
    runApplication<DsmHackathonBackendApplication>(*args)
}
