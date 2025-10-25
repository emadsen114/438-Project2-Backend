package com.example.demo.entities;

import com.example.demo.entities.Favorite;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Favorite Entity Tests")
class FavoriteTest {

    @Test
    @DisplayName("Default constructor test")
    void testDefaultConstructor() {
        Favorite emptyFavorite = new Favorite();

        assertNotNull(emptyFavorite);
        assertEquals(null, emptyFavorite.getFavoriteId());
        assertEquals(null, emptyFavorite.getUserId());
        assertEquals(null, emptyFavorite.getTeamId());
        assertEquals(null, emptyFavorite.getGameId());
    }

    @Test
    @DisplayName("Check if constructor parameters are set correctly")
    void testParameterizedConstructor() {
        Favorite favorite = new Favorite(1L, 2L, 3L);

        assertNotNull(favorite);
        assertEquals(1L, favorite.getUserId());
        assertEquals(2L, favorite.getTeamId());
        assertEquals(3L, favorite.getGameId());
        assertEquals(null, favorite.getFavoriteId());
    }

    @Test
    @DisplayName("Setters and getters tests")
    void testSettersAndGetters() {
        Favorite favorite = new Favorite();

        favorite.setFavoriteId(1L);
        favorite.setUserId(1L);
        favorite.setTeamId(2L);
        favorite.setGameId(3L);

        assertEquals(1L, favorite.getFavoriteId());
        assertEquals(1L, favorite.getUserId());
        assertEquals(2L, favorite.getTeamId());
        assertEquals(3L, favorite.getGameId());
    }
}