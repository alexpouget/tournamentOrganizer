package com.example.entity;


import javax.persistence.*;
import java.util.List;

/**
 * Created by Baba Daryoush on 06/04/2016.
 */
@Entity
@Table(name = "Typetournament")
public class TypeTournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int idTypeTournament;

    @Column(name = "name")
    private String name;



    public int getIdTypeTournament() {
        return idTypeTournament;
    }

    public void setIdTypeTournament(int idTypeTournament) {
        this.idTypeTournament = idTypeTournament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
