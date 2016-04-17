package com.example.controller;

import com.example.entity.*;
import com.example.repository.GameRepository;
import com.example.repository.UserMatchRepository;
import com.example.repository.UserTournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/userMatch")

public class UserMatchController {

    @Autowired
    private UserMatchRepository userMatchRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserTournamentRepository userTournamentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserMatch> getUserMatch() {
        return userMatchRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public UserMatch getUserMatch(@PathVariable int id) {
        return userMatchRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserMatch addUserMatch(@RequestBody UserMatch userMatch) {
        return userMatchRepository.save(userMatch);

    }

        @RequestMapping(method = RequestMethod.PUT, value = "{id}")
        public UserMatch updateUserMatch ( @PathVariable int id, @RequestBody UserMatch userMatch){
            UserMatch userMatch1 = new UserMatch();
            userMatch1.setIdUser(userMatch.getIdUser());
            userMatch1.setId(id);
            userMatch1.setIdGame(userMatch.getIdGame());
            userMatch1.setScore(userMatch.getScore());
            return userMatchRepository.save(userMatch1);
        }

        @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
        public void deleteUserMatch ( @PathVariable int id){
            userMatchRepository.delete(id);
        }




}