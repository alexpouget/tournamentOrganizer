package com.example.controller;


import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by alex on 28/03/2016.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public User getUsers(@PathVariable int id){
        return userRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User addUsers(@RequestBody User user){
        User newUser = userRepository.save(user);
        return newUser;
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    public User updateUsers(@PathVariable int id,@RequestBody User user){
        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setId(id);
        user1.setName(user.getName());
        return userRepository.save(user1);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteUsers(@PathVariable int id){
        userRepository.delete(id);
    }

}
