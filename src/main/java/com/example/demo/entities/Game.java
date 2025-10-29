package com.example.demo.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int season;
    private String team;
    private String opponent;
    private Date date;

    public Game(){}
    public Game(int season, String team, String opponent, Date date){
        this.season = season;
        this.team = team;
        this.opponent = opponent;
        this.date = date;
    }

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