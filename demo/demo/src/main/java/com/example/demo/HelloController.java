package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
