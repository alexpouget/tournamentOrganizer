package com.example.entity;

import javax.persistence.*;

/**
 * Created by Baba Daryoush on 06/04/2016.
 */
@Entity
@Table(name = "Usertournament")
public class UserTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User idUserTournament;

    @ManyToOne
    @JoinColumn(name = "idtournament")
    private Tournament idTournament;

    @Column(name = "points")
    private int points;

    public UserTournament(User idUserTournament, Tournament idTournament, int points) {
        this.idUserTournament = idUserTournament;
        this.idTournament = idTournament;
        this.points = points;
    }

    public UserTournament() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tournament getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(Tournament idTournament) {
        this.idTournament = idTournament;
    }

    public User getIdUserTournament() {
        return idUserTournament;
    }

    public void setIdUserTournament(User idUserTournament) {
        this.idUserTournament = idUserTournament;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
