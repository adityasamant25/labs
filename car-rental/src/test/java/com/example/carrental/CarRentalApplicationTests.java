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
		String response = "[\"marchin\",\"josh\"]";
		WireMock.stubFor(WireMock.get("/fraud").willReturn(WireMock.aResponse().withBody(response)));

		String object = new RestTemplate().getForObject("http://localhost:9876/fraud", String.class);

		BDDAssertions.then(object).isEqualTo(response);
	}

}
