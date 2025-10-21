package com.example.springboot.entities;

import java.sql.Date;

public class Game {
    private int id;
    private int season;
    private int team;
    private String opponent;
    private Date date;

    public int getId() { 
        return id; 
    }
    public void setId(int id) {
         this.id = id; 
    }
    public int getSeason() {
        return season; 
    }
    public void setSeason(int season) {
         this.season = season; 
    }
    public int getTeam() {
         return team; 
    }
    public void setTeam(int team) {
         this.team = team; 
    }
    public String getOpponent() {
         return opponent;
    }
    public void setOpponent(String opponent) { 
        this.opponent = opponent;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
}

