package com.example.demo.entities;

import com.example.demo.entities.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Team Entity Tests")
class TeamTest {

    @Test
    @DisplayName("Default constructor test")
    void testDefaultConstructor() {
        Team emptyTeam = new Team();

        assertNotNull(emptyTeam);
        assertEquals(0, emptyTeam.getId());
        assertNull(emptyTeam.getName());
        assertNull(emptyTeam.getNickname());
        assertNull(emptyTeam.getLogo());
        assertNull(emptyTeam.getNbaFranchise());
    }

    @Test
    @DisplayName("Check if constructor parameters are set correctly")
    void testParameterizedConstructor() {
        Team team = new Team("test", "tast", "tost", true);

        assertNotNull(team);
        assertEquals("test", team.getName());
        assertEquals("tast", team.getNickname());
        assertEquals("tost", team.getLogo());
        assertEquals(true, team.getNbaFranchise());
        assertEquals(0, team.getId());
    }

    @Test
    @DisplayName("Setters and getters tests")
    void testSettersAndGetters() {
        Team team = new Team();

        team.setId(1L);
        team.setName("test");
        team.setNickname("tast");
        team.setLogo("tost");
        team.setNbaFranchise(true);

        assertEquals(1L, team.getId());
        assertEquals("test", team.getName());
        assertEquals("tast", team.getNickname());
        assertEquals("tost", team.getLogo());
        assertEquals(true, team.getNbaFranchise());
    }
}