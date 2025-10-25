package com.example.demo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @GetMapping("/spring")
    public String spring() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping({"/greeting", "/Greeting"})
    public String greeting() {
        return "Hello, Alberto!";
    }

    @GetMapping("/me")
    public Map<String, Object> me(@AuthenticationPrincipal OidcUser user) {
        Map<String, Object> resp = new LinkedHashMap<>();
        resp.put("name", user.getFullName());
        resp.put("email", user.getEmail());
        resp.put("subject", user.getSubject());
        resp.put("claims", user.getClaims()); // full set if you need it
        return resp;
    }
}

