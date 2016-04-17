package com.example.controller;

import com.example.entity.*;
import com.example.repository.*;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserMatchRepository userMatchRepository;
    @Autowired
    private UserTournamentRepository userTournamentRepository;
	@RequestMapping(method = RequestMethod.GET)
    public List<Tournament> getTournaments(){
        return tournamentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public Tournament getTournaments(@PathVariable int id){
        return tournamentRepository.findOne(id);
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
		tournament1.setTypeTournament(tournament.getTypeTournament());
        return tournamentRepository.save(tournament1);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteTournament(@PathVariable int id){
        //suppression des dependence  UserMatch UserTournament  Game  User Tournament
        List<User> userList = userTournamentRepository.getidUserTournament(id);
        List<Game> gameList = gameRepository.getAllByIdTournament(id);

        for (Game g:gameList) {
            List<UserMatch> list = userMatchRepository.getByGameId(g.getId());
            userMatchRepository.delete(list);
        }
        userMatchRepository.flush();

        List<UserTournament> listUserTournament = userTournamentRepository.getAllByIdTournament(id);
        userTournamentRepository.delete(listUserTournament);
        userTournamentRepository.flush();

        gameRepository.delete(gameList);
        gameRepository.flush();

        userRepository.delete(userList);
        userRepository.flush();
        tournamentRepository.delete(id);
        tournamentRepository.flush();
    }



}