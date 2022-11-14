package com.mink.javaspringnb1.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "klub")
public class Club {

    @Id
    private int id;

    @Column(name = "csapatnev")
    private String teamName;

    @OneToMany(mappedBy = "clubID")
    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
