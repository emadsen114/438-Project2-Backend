package com.example.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springboot.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}