package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Game;
import com.example.springboot.GameNotFoundException;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class GamesController {

	// This should help us access the database when it exists.
	// If you want to check my work here is the tutorial I followed: https://spring.io/guides/gs/accessing-data-mysql
	// I also consulted this for parts that don't match: https://github.com/dclinkenbeard/CST438_books_sample/tree/main

	// Theres a good chance we may have to change things so I have commented this part out for later
	// private final TeamsRepository repository;
	// HelloController(TeamsRepository repository) {
	// 	this.repository = repository;
	// }

	private final GameRepository gameRepo;

	GamesController(GameRepository gameRepo){
		this.gameRepo = gameRepo;
	}

	@GetMapping("/games")
  	List<Game> all() {
    	return gameRepo.findAll();
  	}

	@GetMapping("/games/{date}")
	public String second() {
        // it would return all the stuff between the date 
		return "Greetings from second page!";
	} 

	//Single item returned 
  	@GetMapping("/games/{id}")
public Game one(@PathVariable Integer id) {
    return gameRepo.findById(id)
        .orElseThrow(() -> new GameNotFoundException(id));
}

}