package com.example.entity;

import javax.persistence.*;

/**
 * Created by Baba Daryoush on 06/04/2016.
 */
@Entity
@Table(name = "Tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    @Column(name = "idTypeTournament")
    private int idTypeTournament;

    @Column(name = "nbPlayer")
    private int nbPlayer;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdTypeTournament() {
        return idTypeTournament;
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdTypeTournament(int idTypeTournament) {
        this.idTypeTournament = idTypeTournament;
    }

    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
    }
}
