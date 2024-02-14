package com.mtrybala.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/projects/**").hasAnyRole("USER", "ADMIN") // dostęp dla użytkowników i adminów
                        .requestMatchers("/projects/config/**").hasRole("ADMIN") // dostęp tylko dla adminów
                        .requestMatchers("/admin/**").hasRole("ADMIN") // dostęp do ścieżek administracyjnych tylko dla adminów
                        .anyRequest().authenticated() // wszystkie inne żądania wymagają uwierzytelnienia
                )
                .httpBasic(withDefaults()); // metoda uwierzytelniania

        return http.build();
    }
}