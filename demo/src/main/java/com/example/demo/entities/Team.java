package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;
  private String nickname;
  private String logo;

  private boolean nbaFranchise;

  public long getId() {
    return id;
  }

  public void setId(long id) {  // changed from Integer to long
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }
}
