package com.example.carrental;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureWireMock(port = 9876)
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.example:fraud-detection:+:stubs:9876")
class CarRentalApplicationTests {

	/*
	 * @Rule public StubRunnerRule rule = new StubRunnerRule().downloadStub(
	 * "com.example:fraud-detection:0.0.1-SNAPSHOT:stubs")
	 * .withPort(9876).stubsMode(StubRunnerProperties.StubsMode.LOCAL);
	 */

	@Test
	public void should_return_a_list_of_frauds() {
		String response = "[\"marcin\",\"josh\"]";
		/*
		 * WireMock.stubFor(WireMock.get("/frauds").willReturn(WireMock.aResponse().
		 * withBody(response)));
		 */

		String object = new RestTemplate().getForObject("http://localhost:9876/fraud", String.class);

		BDDAssertions.then(object).isEqualTo(response);
	}

	/*
	 * @Test public void should_return_a_list_of_frauds_from_a_real_application() {
	 * String response = "[\"marcin\",\"josh\"]";
	 * 
	 * String object = new
	 * RestTemplate().getForObject("http://localhost:9875/frauds", String.class);
	 * 
	 * BDDAssertions.then(object).isEqualTo(response); }
	 */

}
