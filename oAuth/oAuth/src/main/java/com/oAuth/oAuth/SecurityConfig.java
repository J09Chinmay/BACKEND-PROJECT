package com.oAuth.oAuth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers("/", "/login", "/error").permitAll()
                                                .anyRequest().authenticated())
                                .oauth2Login(oauth2Login -> oauth2Login
                                                .defaultSuccessUrl("/home", true)
                                                .failureUrl("/login?error=true")
                                                .successHandler(new SimpleUrlAuthenticationSuccessHandler("/home")));
                return http.build();
        }
}
