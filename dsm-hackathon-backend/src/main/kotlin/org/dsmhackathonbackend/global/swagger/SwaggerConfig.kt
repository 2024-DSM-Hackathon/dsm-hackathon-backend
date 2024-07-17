package org.dsmhackathonbackend.global.swagger

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders


@OpenAPIDefinition
@Configuration
class SwaggerConfig {
    @Bean
    fun openAPI(): OpenAPI {
        val server: Server = Server()
        server.url = "https://obliging-unified-toucan.ngrok-free.app"
        return OpenAPI()
            .servers(listOf
                (server))
            .info(
                Info()
                    .title("해커톤 API")
                    .description("해커톤 API 명세입니다.")
                    .version("v1")
            )
            .components(
                Components()
                    .addSecuritySchemes("Access Token (Bearer)", createAPIKeyScheme())
            )
            .addSecurityItem(
                SecurityRequirement()
                    .addList("Access Token (Bearer)")
                    .addList("Refresh Token")
            )
    }

    private fun createAPIKeyScheme(): SecurityScheme {
        return SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT")
            .`in`(SecurityScheme.In.HEADER)
            .name(HttpHeaders.AUTHORIZATION)
    }
}
