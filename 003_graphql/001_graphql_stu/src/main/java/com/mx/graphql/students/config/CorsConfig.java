package com.mx.graphql.students.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter; // IMPORTAR CORRECTAMENTE EL FILTRO DE SPRING

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // Permitir credenciales
        config.addAllowedOrigin("http://127.0.0.1:5500"); // Permitir origen específico
        config.addAllowedHeader("*"); // Permitir todos los headers
        config.addAllowedMethod("*"); // Permitir todos los métodos (GET, POST, etc.)

        // Aplica CORS solo a la ruta de GraphQL
        source.registerCorsConfiguration("/graphql", config);

        return new CorsFilter(source); // Retornar correctamente el filtro con la configuración
    }
}
