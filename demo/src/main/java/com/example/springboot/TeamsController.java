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

	private final TeamRepository teamRepo;

	TeamsController(TeamRepository teamRepo){
		this.teamRepo = teamRepo;
	}

	@GetMapping("/teams")
	List<Team> all() {
		return repository.findAll();
	}

	@GetMapping("/teams/{id}")
	EntityModel<Team> one(@PathVariable Long id) {
		return repository.findById(id)
		.orElseThrow();
	// return EntityModel.of(team,
    //     linkTo(methodOn(HelloController.class).one(id)).withSelfRel(),
    //     linkTo(methodOn(HelloController.class).all()).withRel("teams"));
	}

	/*
	
	@PostMapping("/teams")
	Team newTeam(@RequestBody Team newTeam) {
		return repository.save(newTeam);
	}

  @PutMapping("/teamss/{id}")
  Team replaceTeam(@RequestBody Team newTeam, @PathVariable Long id) {
    return repository.findById(id).map(team -> {
          team.setName(newTeam.getName());
          team.setNickname(newTeam.getNickname());
          team.setLogo(newTeam.getLogo());
          team.setnbaFranchise(newTeam.getnbaFranchise());
          return repository.save(team);
        })
        .orElseGet(() -> {
          return repository.save(newTeam);
        });
  }

  @DeleteMapping("/team/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
	*/

}