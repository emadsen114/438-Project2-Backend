package com.example.demo.entities;

import com.example.demo.entities.Game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Game Entity Tests")
class GameTest {

    private Game game1;
    private Game game2;
    private Game game3;

    @BeforeEach
    void setUp() {
        game1 = new Game(2024, "Dallas Mavericks", "Los Angeles Clippers", new Date(1729641600));
        game2 = new Game(2024, "Chicago Bulls", "New Orleans Pelicans", new Date(1750896000));
        game3 = new Game(2021, "Milwaukee Bucks", "Brooklyn Nets", new Date(1644105600));
    }

    @Test
    @DisplayName("Default constructor test")
    void testDefaultConstructor() {
        Game emptyGame = new Game();

        assertNotNull(emptyGame);
        assertEquals(0, emptyGame.getId());
        assertEquals(0, emptyGame.getSeason());
        assertNull(emptyGame.getTeam());
        assertNull(emptyGame.getOpponent());
        assertNull(emptyGame.getDate());
    }

    @Test
    @DisplayName("Check if constructor parameters are set correctly")
    void testParameterizedConstructor() {
        Game game = new Game(9999, "Someone", "Somone else", new Date(0));

        assertNotNull(game);
        assertEquals(9999, game.getSeason());
        assertEquals("Someone", game.getTeam());
        assertEquals("Somone else", game.getOpponent());
        assertEquals(new Date(0), game.getDate());
        assertEquals(0, game.getId());
    }

    @Test
    @DisplayName("Setters and getters tests")
    void testSettersAndGetters() {
        Game game = new Game();

        game.setId(1L);
        game.setSeason(9999);
        game.setTeam("Someone");
        game.setOpponent("Somone else");
        game.setDate(new Date(0));

        assertEquals(1L, game.getId());
        assertEquals(9999, game.getSeason());
        assertEquals("Someone", game.getSomeone());
        assertEquals("Somone else", game.getOpponent());
        assertEquals(new Date(0), game.getDate());
    }
}