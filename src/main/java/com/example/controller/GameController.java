package com.example.controller;

import com.example.entity.Game;
import com.example.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/game")

public class GameController {

@Autowired
    private GameRepository gameRepository;
	@RequestMapping(method = RequestMethod.GET)
    public List<Game> getGames(){
        return gameRepository.findAll();
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Game addGames(@RequestBody Game game){
        Game newGame = gameRepository.save(game);
        return newGame;
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

}