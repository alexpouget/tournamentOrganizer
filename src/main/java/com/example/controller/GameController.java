package com.example.controller;

import com.example.entity.*;
import com.example.repository.GameRepository;
import com.example.repository.UserMatchRepository;
import com.example.repository.UserTournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    private UserMatchRepository userMatchRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserTournamentRepository userTournamentRepository;
	@RequestMapping(method = RequestMethod.GET)
    public List<Game> getGames(){
        return gameRepository.findAll();
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Game addGames(@RequestBody Game game){
        System.out.println("game controller");
        List<UserMatch> list = new ArrayList<>();
        Tournament tournament = game.getIdTournament();
        switch (tournament.getTypeTournament().getName()) {
            case "tournoi direct":
                //cree tous les match avec des position et attribuer des joueurs pour tous les match
                break;
            case "Tournoi avec groupe":
                // championnat par groupe puis tournoi direct
                break;
            case "Championnat":
                List<UserTournament> players = userTournamentRepository.getAllByIdTournament(tournament.getId());
                list =  generateLeague(players,tournament);
                break;
        }
        return new Game();
       // return gameRepository.getAllByIdTournament(tournament.getId());
    }
	
	@RequestMapping(method = RequestMethod.PUT, value="{id}")
    public Game updateGame(@PathVariable int id,@RequestBody Game game){
        Game game1 = new Game();
        game1.setPosition(game.getPosition());
        game1.setId(id);
        game1.setGroupe(game.getGroupe());
		game1.setIdTournament(game.getIdTournament());
        return gameRepository.save(game1);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteGame(@PathVariable int id){
        gameRepository.delete(id);
    }

    private List<UserMatch> generateLeague(List<UserTournament> players, Tournament tournament) {
        List<UserMatch> list = new ArrayList<>();
        Boolean[][] alreadyMatch = new Boolean[players.size()][players.size()];
        for (int i =0;i<players.size();i++){
            for (int y =0;y<players.size();y++) {
                alreadyMatch[i][y] = false;
            }
        }
        Random random = new Random();
        int y = 1;
        for (int i = 1; i < players.size(); i++) {
            List<UserTournament> p = players;
            while (!p.isEmpty()) {
                Game game = new Game();
                game.setPosition(y);
                game.setIdTournament(tournament);
                y++;
                game = gameRepository.save(game);

                UserMatch userMatch = new UserMatch();
                userMatch.setIdGame(game);
                int index = random.nextInt(p.size());
                userMatch.setIdUser(p.get(index));
                p.remove(index);
                userMatch.setScore(0);
                list.add(userMatch);

                UserMatch userMatch2 = new UserMatch();
                userMatch2.setIdGame(game);
                int index1 = 0;
                do {
                    index1 = random.nextInt(p.size());
                }
                while ((alreadyMatch[index][index1]) || (alreadyMatch[index1][index]));
                userMatch2.setIdUser(p.get(index1));
                p.remove(index1);
                userMatch2.setScore(0);
                list.add(userMatch2);

                alreadyMatch[index][index1] = true;
                alreadyMatch[index1][index] = true;
            }
        }
        userTournamentRepository.flush();
        gameRepository.flush();
        List<UserMatch> newUserMatch = userMatchRepository.save(list);
        userMatchRepository.flush();
        return newUserMatch;
    }
}