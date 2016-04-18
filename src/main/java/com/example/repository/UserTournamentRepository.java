package com.example.repository;

import com.example.entity.User;
import com.example.entity.UserMatch;
import com.example.entity.UserTournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTournamentRepository extends JpaRepository<UserTournament,Integer> {

    @Query("select a.idUserTournament from UserTournament a where a.idTournament.id = :id")
    List<User> getidUserTournament(@Param("id") int idTournament);

    @Query("select a from UserTournament a where a.idTournament.id = :id")
    List<UserTournament> getAllByIdTournament(@Param("id") int idTournament);


    @Query("select a from UserTournament a where a.idTournament.id = :id")
    void deleteByIdTournament(@Param("id") int idTournament);
}
