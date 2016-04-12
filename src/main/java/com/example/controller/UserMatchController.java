package com.example.controller;

import com.example.entity.UserMatch;
import com.example.repository.UserMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/userMatch")

public class UserMatchController {

@Autowired
    private UserMatchRepository userMatchRepository;
	@RequestMapping(method = RequestMethod.GET)
    public List<UserMatch> getUserMatch(){
        return userMatchRepository.findAll();
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public UserMatch addUserMatch(@RequestBody UserMatch userMatch){
        UserMatch newUserMatch = userMatchRepository.save(userMatch);
        return newUserMatch;
    }
	
	@RequestMapping(method = RequestMethod.PUT, value="{id}")
    public UserMatch updateUserMatch(@PathVariable int id,@RequestBody UserMatch userMatch){
        UserMatch userMatch1 = new UserMatch();
        userMatch1.setIdUser(userMatch.getIdUser());
        userMatch1.setId(id);
        userMatch1.setIdGame(userMatch.getIdGame());
		userMatch1.setScore(userMatch.getScore());
        return userMatchRepository.save(userMatch1);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteUserMatch(@PathVariable int id){
        userMatchRepository.delete(id);
    }

}