package com.example.cors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 모든 엔드포인트에 대해 CORS 허용
        registry.addMapping("/**")
                // 허용된 출처
                .allowedOrigins("http://frontend.example.com")
                // 허용된 메서드
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*") // 모든 요청 헤더 허용
                .allowCredentials(true) // 쿠키 전송 허용
                .maxAge(3600); // 1시간 동안 캐시
    }
}
