package com.microservices.login.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // Optional: only needed if you want to disable Spring Boot’s auto-configuration of Spring MVC
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/login/**") // Apply CORS to the specified paths
            .allowedOrigins("http://localhost:3000","http://localhost:3001","http://localhost:3002") // Allow requests from this origin
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true); // Allow cookies or credentials
    }
}
