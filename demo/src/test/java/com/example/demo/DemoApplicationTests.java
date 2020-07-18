package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import io.restassured.RestAssured;

@SpringBootTest
class DemoApplicationTests {

	private static final int PORT = 8081;
	private static final String HOST = "localhost";

	private static WireMockServer server = new WireMockServer(PORT);

	@Rule
	public WireMockRule rule = new WireMockRule(8081);

	@Autowired
	PersonService personService;

	/*
	 * @Before public void setup() { server.start(); WireMock.configureFor(HOST,
	 * PORT);
	 * WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/person/1")).willReturn(
	 * WireMock.aResponse().withHeader("Content-Type",
	 * "application/json").withBody("{\"name\":\"m1\"}")));
	 * WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/person/2")).willReturn(
	 * WireMock.aResponse().withHeader("Content-Type",
	 * "application/json").withBody("{\"name\":\"m2\"}"))); }
	 */

	/*
	 * @Test public void should_get_two_people() { List<Person> people =
	 * this.personService.people();
	 * 
	 * BDDAssertions.then(people).hasSize(2); }
	 */

	@Test
	public void testGetEndPoint() throws URISyntaxException {
		server.start();
		WireMock.configureFor(HOST, PORT);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/person/1")).willReturn(
				WireMock.aResponse().withHeader("Content-Type", "application/json").withBody("{\"name\":\"m1\"}")));
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/person/2")).willReturn(
				WireMock.aResponse().withHeader("Content-Type", "application/json").withBody("{\"name\":\"m2\"}")));
		List<Person> people = this.personService.people();

		BDDAssertions.then(people).hasSize(2);

		RestAssured.given().when().get(new URI("http://localhost:8081/person/1")).then().assertThat().statusCode(200);

		if (null != server && server.isRunning()) {
			server.shutdown();
		}
	}

	/*
	 * @After public static void teardown() { if (null != server &&
	 * server.isRunning()) { server.shutdown(); } }
	 */

}
