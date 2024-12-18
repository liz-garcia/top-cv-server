package com.topcv.topcvserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable) // temporary for initial dev setup
                .csrf(AbstractHttpConfigurer::disable) // temporary for initial dev setup
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless sessions
                .formLogin(AbstractHttpConfigurer::disable) // Disable form login
                .securityMatcher("/**") // Ensure the filter chain to all requests. Could also be set to "/api/**"
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/").permitAll() // Allow public access to "/" without requiring authentication
                        .anyRequest().authenticated() // Require authentication for all other routes
                );

        return http.build();
    }
}
