package org.educastur.samuelepv59.todo_list.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:3000",
                        "https://todofront-production-d1bf.up.railway.app" // 💡 ¡Faltaba esto!
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*") // Importante para permitir Authorization y Content-Type
                .allowCredentials(true) // Debe coincidir con tu SecurityConfig
                .maxAge(3600);
    }
}