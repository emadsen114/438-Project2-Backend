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
          "/", "/login",               // keep home public; allow your /login -> Google redirect
          "/spring", "/greeting", "/Greeting",
          "/error", "/actuator/**",
          "/css/**", "/js/**", "/images/**"
        ).permitAll()
        .anyRequest().authenticated()
      )
      // default Google entry: /oauth2/authorization/google
      .oauth2Login(o -> o
        .defaultSuccessUrl("/me", true) // always land on /me after login
      )
      .logout(logout -> logout
        .logoutSuccessUrl("/")          // after logout, return home
        .permitAll()
      );

    return http.build();
  }
}
