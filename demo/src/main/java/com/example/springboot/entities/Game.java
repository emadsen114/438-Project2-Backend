package com.example.springboot.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int season;

    private int team;  // You could also make this a foreign key to Team later

    private String opponent;

    private Date date;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getSeason() { return season; }
    public void setSeason(int season) { this.season = season; }

    public int getTeam() { return team; }
    public void setTeam(int team) { this.team = team; }

    public String getOpponent() { return opponent; }
    public void setOpponent(String opponent) { this.opponent = opponent; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}