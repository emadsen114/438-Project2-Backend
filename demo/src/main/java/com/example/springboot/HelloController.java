package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class HelloController {
// just NBA sports betting 



	/// get methods 
	/// 
	/// correlates to the GET methods in node 
	/// we are familiar with 
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

    @GetMapping({"/greeting", "/Greeting"})
    public String greeting() {
        return "Hello, Alberto!";
    }
}
