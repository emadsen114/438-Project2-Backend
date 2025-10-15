package com.example.springboot;

public class GameNotFoundException extends RuntimeException {

  public GameNotFoundException(Integer id) {
    super("Could not find game: " + id);
  }
}
