package com.mink.javaspringnb1.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "poszt")
public class Post {

    @Id
    private int id;

    @Column(name = "nev")
    private String name;

    @OneToMany(mappedBy = "postID")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
