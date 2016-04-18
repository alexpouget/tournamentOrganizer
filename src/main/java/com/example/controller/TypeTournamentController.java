package com.example.controller;

import com.example.entity.TypeTournament;
import com.example.repository.TypeTournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.jws.soap.SOAPBinding;
import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/typeTournament")

public class TypeTournamentController {

@Autowired
    private TypeTournamentRepository typeTournamentRepository;
	@RequestMapping(method = RequestMethod.GET)
    public List<TypeTournament> getTypeTournaments(){
        return typeTournamentRepository.findAll();
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public TypeTournament addTypeTournaments(@RequestBody TypeTournament typeTournament){
        TypeTournament newTypeTournament = typeTournamentRepository.save(typeTournament);
        return newTypeTournament;
    }
	
	@RequestMapping(method = RequestMethod.PUT, value="{id}")
    public TypeTournament updateTypeTournament(@PathVariable int id,@RequestBody TypeTournament typeTournament){
        TypeTournament typeTournament1 = new TypeTournament();
        typeTournament1.setName(typeTournament.getName());
        typeTournament1.setIdTypeTournament(id);
        return typeTournamentRepository.save(typeTournament1);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteTypeTournament(@PathVariable int id){
        typeTournamentRepository.delete(id);
    }

}