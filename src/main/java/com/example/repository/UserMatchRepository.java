package com.example.repository;

import com.example.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.entity.UserMatch;

import java.util.List;

@Repository
public interface UserMatchRepository extends JpaRepository<UserMatch,Integer> {

    @Query("select a from UserMatch a where a.idGame.id = :id")
    List<UserMatch> getByGameId(@Param("id") int idGame);

}
