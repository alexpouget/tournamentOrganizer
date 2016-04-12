package com.example.controller;

import com.example.entity.Tournament;
import com.example.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/tournament")

public class TournamentController {

@Autowired
    private TournamentRepository tournamentRepository;
	@RequestMapping(method = RequestMethod.GET)
    public List<Tournament> getTournaments(){
        return tournamentRepository.findAll();
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Tournament addTournament(@RequestBody Tournament tournament){
        Tournament newTournament = tournamentRepository.save(tournament);
        return newTournament;
    }
	
	@RequestMapping(method = RequestMethod.PUT, value="{id}")
    public Tournament updateTournament(@PathVariable int id,@RequestBody Tournament tournament){
        Tournament tournament1 = new Tournament();
        tournament1.setNbPlayer(tournament.getNbPlayer());
        tournament1.setId(id);
        tournament1.setName(tournament.getName());
		tournament1.setIdTypeTournament(tournament.getIdTypeTournament());
        return tournamentRepository.save(tournament1);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteTournament(@PathVariable int id){
        tournamentRepository.delete(id);
    }

}