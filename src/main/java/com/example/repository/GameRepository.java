package com.example.repository;

import com.example.entity.UserMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.entity.Game;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {

    @Query("select a from Game a where a.idTournament.id = :id")
    List<Game> getAllByIdTournament(@Param("id") int idTournament);


}
