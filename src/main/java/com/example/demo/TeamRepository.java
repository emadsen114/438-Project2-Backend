package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
