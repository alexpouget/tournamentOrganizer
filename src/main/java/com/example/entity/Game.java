package com.example.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Baba Daryoush on 05/04/2016.
 */
@Entity
@Table(name = "Game")
public class Game {
    public Game(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "groupe")
    private int groupe;


    @Column(name = "position")
    private int position;

    @ManyToOne
    @JoinColumn(name = "idtournament")
    private Tournament idTournament;

    public Game(int groupe, int position, Tournament idTournament) {
        this.groupe = groupe;
        this.position = position;
        this.idTournament = idTournament;
    }



    public int getId(){
        return id;
    }


    public int getPosition(){
        return position;
    }

    public int getGroupe(){
        return groupe;
    }

    public void setGroupe(int groupe){
        this.groupe = groupe;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public void setId(int id){
        this.id = id;
    }

    public Tournament getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(Tournament idTournament) {
        this.idTournament = idTournament;
    }

}
