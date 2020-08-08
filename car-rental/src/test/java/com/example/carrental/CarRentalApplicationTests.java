package com.example.carrental;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.web.client.RestTemplate;

import com.github.tomakehurst.wiremock.client.WireMock;

@SpringBootTest
@AutoConfigureWireMock(port = 9876)
class CarRentalApplicationTests {

	@Test
	public void should_return_a_list_of_frauds() {
		String response = "[\"marcin\",\"josh\"]";
		WireMock.stubFor(WireMock.get("/fraud123").willReturn(WireMock.aResponse().withBody(response)));

		String object = new RestTemplate().getForObject("http://localhost:9876/fraud123", String.class);

		BDDAssertions.then(object).isEqualTo(response);
	}
	
	@Test
	public void should_return_a_list_of_frauds_from_a_real_application() {
		String response = "[\"marcin\",\"josh\"]";

		String object = new RestTemplate().getForObject("http://localhost:9875/frauds", String.class);

		BDDAssertions.then(object).isEqualTo(response);
	}

}
