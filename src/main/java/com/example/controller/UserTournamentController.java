package com.example.controller;

import com.example.entity.UserTournament;
import com.example.repository.TournamentRepository;
import com.example.repository.UserTournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/userTournament")
public class UserTournamentController {

    @Autowired
    private UserTournamentRepository userTournamentRepository;

	@RequestMapping(method = RequestMethod.GET)
    public List<UserTournament> getUserTournament(){
        return userTournamentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public UserTournament getUserTournament(@PathVariable int id){
        return userTournamentRepository.findOne(id);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public UserTournament addUserTournament(@RequestBody UserTournament userTournament){

            UserTournament newUserTournament = userTournamentRepository.save(userTournament);

            return newUserTournament;

    }
	
	@RequestMapping(method = RequestMethod.PUT, value="{id}")
    public UserTournament updateUserTournament(@PathVariable int id,@RequestBody UserTournament userTournament){
        UserTournament userTournament1 = new UserTournament();
        userTournament1.setIdUserTournament(userTournament.getIdUserTournament());
        userTournament1.setId(id);
        userTournament1.setIdTournament(userTournament.getIdTournament());
        userTournament1.setPoints(userTournament.getPoints());
        return userTournamentRepository.saveAndFlush(userTournament1);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteUserTournament(@PathVariable int id){
        userTournamentRepository.delete(id);
    }

}