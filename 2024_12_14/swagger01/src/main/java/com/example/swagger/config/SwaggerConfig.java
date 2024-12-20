package com.example.swagger.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "User API",
                version = "1.0",
                description = "사용자 관리를 위한 REST API"
        ),
        servers = @Server(url = "http://localhost:8080", description = "Local Server")
)
public class SwaggerConfig {
    // 빈 설정 또는 설정 클래스
}
