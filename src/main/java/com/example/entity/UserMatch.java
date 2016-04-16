package com.example.entity;

import javax.persistence.*;

/**
 * Created by Baba Daryoush on 06/04/2016.
 */
@Entity
@Table(name = "Usermatch")
public class UserMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User idUser;


    @Column(name = "score")
    private int score;

    @ManyToOne
    @JoinColumn(name = "idgame")
    private Game idGame;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Game getIdGame() {
        return idGame;
    }

    public void setIdGame(Game idGame) {
        this.idGame = idGame;
    }
}