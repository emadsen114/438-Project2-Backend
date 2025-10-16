package com.example.demo.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int season;

    private String team;  // You could also make this a foreign key to Team later

    private String opponent;

    private Date date;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public int getSeason() { return season; }
    public void setSeason(int season) { this.season = season; }

    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }

    public String getOpponent() { return opponent; }
    public void setOpponent(String opponent) { this.opponent = opponent; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}