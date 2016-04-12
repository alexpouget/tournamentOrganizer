package com.example.entity;

import javax.persistence.*;

/**
 * Created by Baba Daryoush on 06/04/2016.
 */
@Entity
@Table(name = "UserMatch")
public class UserMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "idUser")
    private String idUser;


    @Column(name = "score")
    private int score;

    @Column(name = "idGame")
    private int idGame;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }
}
