package com.example;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TournamentOrganizerApplication.class)
@WebIntegrationTest("server.port=8181")
public class TournamentOrganizerApplicationTests {

	@Before
	public void setup(){
		RestAssured.port = 8181;
	}
	@Test
	public void contextLoads() {
		given()
			.log().all()
			.when()
			.get("/user")
		.then()
			.log().all()
			.statusCode(200)
			.body("$",hasSize(1));
	}

}
