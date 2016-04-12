package com.example.entity;

import javax.persistence.*;

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

    @Column(name = "idTournament")
    private int idTournament;

    public int getId(){
        return id;
    }

    public int getIdTournament(){
        return idTournament;
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

    public void setIdTournament(int idTournament){
        this.idTournament =  idTournament;
    }

    public void setId(int id){
        this.id = id;
    }
}
