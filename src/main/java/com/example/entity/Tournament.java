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

    @ManyToOne
    @JoinColumn(name = "idtypetournament")
    private TypeTournament typeTournament;

    @Column(name = "nbplayer")
    private int nbPlayer;

    public Tournament(String name, TypeTournament typeTournament, int nbPlayer) {
        this.name = name;
        this.typeTournament = typeTournament;
        this.nbPlayer = nbPlayer;
    }

    public Tournament() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public TypeTournament getTypeTournament() {
        return typeTournament;
    }

    public void setTypeTournament(TypeTournament typeTournament) {
        this.typeTournament = typeTournament;
    }

    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
    }
}
