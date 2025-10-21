package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Game;
import com.example.demo.GameNotFoundException;

@RestController
public class GamesController {

	private final GameRepository gameRepository;

	public GamesController(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	@GetMapping("/games")
	public List<Game> all() {
		return gameRepository.findAll();
	}
	@GetMapping("/games/id/{id:\\d+}")
   public Game one(@PathVariable Long id) {             
   return gameRepository.findById(id)
           .orElseThrow(() -> new GameNotFoundException(id));
   }
}
