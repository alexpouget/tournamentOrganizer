package com.example;

import com.example.controller.GameController;
import com.example.controller.UserTournamentController;
import com.example.entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TournamentOrganizerApplication.class)
@WebIntegrationTest("server.port=8181")
@Profile("dev")
public class TournamentOrganizerApplicationTests {
	@Autowired
	ObjectMapper objectMapper;

	public <T> String toJson(T entity){
		try{

			return objectMapper.writeValueAsString(entity);

		} catch (JsonProcessingException e) {
			return null;
		}
	}

	@Before
	public void setup(){
		RestAssured.port = 8181;
	}

	@Test
	public void add_user(){
		User user = new User("babar", "baba@gmail.com");
		given()
				.log().all()
				.contentType(ContentType.JSON)
				.body(toJson(user))
				.when()
				.post("/user")
				.then()
				.log().all()
				.statusCode(200);
	}

	@Test
	public void delete_user(){
		given()
				.log().all()
				.param("id", 79)
				.when()
				.delete("/user")
				.then()
				.log().all()
				.statusCode(200);
	}
	@Test
	public void get_user(){
		given()
				.log().all()
				.param("{id}", 79)
				.when()
				.get("/user")
				.then()
				.log().all()
				.statusCode(200);
	}
	@Test
	public void update_user(){
		User user = new User("michax", "baba@gmail.com");
		given()
				.log().all()
				.contentType(ContentType.JSON)
				.body(toJson(user))
				.param("id", 79)
				.when()
				.put("/user")
				.then()
				.log().all()
				.statusCode(200);
	}
	@Test
	public void get_tournaments(){
		given()
				.log().all()
				.when()
				.get("/tournament")
				.then()
				.log().all()
				.statusCode(200);
	}
	@Test
	public void add_tournament(){
		TypeTournament typeTournament = new TypeTournament("Championnat");
		Tournament tournament = new Tournament("fred", typeTournament, 15);

		given()
				.log().all()
				.contentType(ContentType.JSON)
				.body(toJson(tournament))
				.when()
				.post("/tournament")
				.then()
				.log().all()
				.statusCode(200);
	}
	@Test
	public void add_game(){
		TypeTournament typeTournament = new TypeTournament("Championnat");
		Tournament tournament = new Tournament("fred", typeTournament, 15);
		Game game = new Game(13, 15, tournament);

		given()
				.log().all()
				.contentType(ContentType.JSON)
				.body(toJson(game))
				.when()
				.post("/game")
				.then()
				.log().all()
				.statusCode(200);
	}
	@Test
	public void get_games(){
		given()
				.log().all()
				.when()
				.get("/game")
				.then()
				.log().all()
				.statusCode(200);
	}
	@Test
	public void add_userMatch(){
		User user = new User("michax", "baba@gmail.com");
		TypeTournament typeTournament = new TypeTournament("Championnat");
		Tournament tournament = new Tournament("fred", typeTournament, 15);
		UserTournament userTournament = new UserTournament(user, tournament, 23);
		Game game = new Game(13, 15, tournament);
		UserMatch userMatch = new UserMatch(userTournament, 78, game);

		given()
				.log().all()
				.contentType(ContentType.JSON)
				.body(toJson(userMatch))
				.when()
				.post("/userMatch")
				.then()
				.log().all()
				.statusCode(200);
	}
	@Test
	public void get_userMatchs(){
		given()
				.log().all()
				.when()
				.get("/userMatch")
				.then()
				.log().all()
				.statusCode(200);
	}
	@Test
	public void get_userTournaments(){
		given()
				.log().all()
				.when()
				.get("/userTournament")
				.then()
				.log().all()
				.statusCode(200);
	}
	@Test
	public void add_userTournament(){
		User user = new User("michax", "baba@gmail.com");
		TypeTournament typeTournament = new TypeTournament("Championnat");
		Tournament tournament = new Tournament("fred", typeTournament, 15);
		UserTournament userTournament = new UserTournament(user, tournament, 23);

		given()
				.log().all()
				.contentType(ContentType.JSON)
				.body(toJson(userTournament))
				.when()
				.post("/userTournament")
				.then()
				.log().all()
				.statusCode(200);
	}
}

