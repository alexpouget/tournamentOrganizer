package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.entity.TypeTournament;

import java.util.List;

@Repository
public interface TypeTournamentRepository extends JpaRepository<TypeTournament,Integer> {

}
