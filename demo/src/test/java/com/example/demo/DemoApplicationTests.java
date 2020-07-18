package com.example.demo;

import java.net.URISyntaxException;
import java.util.List;

import org.assertj.core.api.BDDAssertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

@SpringBootTest
class DemoApplicationTests {

	private static final int PORT = 8081;
	private static final String HOST = "localhost";

	private static WireMockServer server = new WireMockServer(PORT);

	@Autowired
	PersonService personService;

	@BeforeAll
	public static void setup() {
		server.start();
		WireMock.configureFor(HOST, PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/person/1")).willReturn(
				WireMock.aResponse().withHeader("Content-Type", "application/json").withBody("{\"name\":\"m1\"}")));
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/person/2")).willReturn(
				WireMock.aResponse().withHeader("Content-Type", "application/json").withBody("{\"name\":\"m2\"}")));
	}

	@Test
	public void should_get_two_people() {
		List<Person> people = this.personService.people();

		BDDAssertions.then(people).hasSize(2);
	}

	@Test
	public void should_get_two_people_using_rest_assured() throws URISyntaxException {

		RestAssured.given().baseUri("http://localhost:8081").when().get("/person/{id}", 1).then().statusCode(200)
				.contentType("application/json").body("name", Matchers.equalTo("m1"));
	}

	@AfterAll
	public static void teardown() {
		if (null != server && server.isRunning()) {
			server.shutdown();
		}
	}

}
