package com.example.springboot;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.entities.Team;

public interface TeamsRepository extends CrudRepository<Team, Long> {

}