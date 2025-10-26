package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers(
          "/", "/login",
          "/spring", "/greeting", "/Greeting", 
          "/error", "/actuator/**",
          "/css/**", "/js/**", "/images/**"
        ).permitAll()
        .requestMatchers("/teams", "/games", "/favorites/**").authenticated()
        .anyRequest().authenticated()
      )
      .oauth2Login(o -> o
        .defaultSuccessUrl("/me", true)
      )
      .logout(logout -> logout
        .logoutSuccessUrl("/")
        .permitAll()
      );

    return http.build();
  }
}
