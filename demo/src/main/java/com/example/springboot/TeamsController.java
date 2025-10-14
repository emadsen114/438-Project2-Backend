package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class TeamsController {

	// This should help us access the database when it exists.
	// If you want to check my work here is the tutorial I followed: https://spring.io/guides/gs/accessing-data-mysql
	// I also consulted this for parts that don't match: https://github.com/dclinkenbeard/CST438_books_sample/tree/main

	// Theres a good chance we may have to change things so I have commented this part out for later
	// private final TeamsRepository repository;
	// HelloController(TeamsRepository repository) {
	// 	this.repository = repository;
	// }

	@GetMapping("/teams")
	public String index() {
		return "team";
	}

	// @GetMapping("/second")
	// public String second() {
	// 	return "Greetings from second page!";
	// }

}