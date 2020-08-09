package com.example.frauddetection;

import org.junit.Before;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

public class BaseClass {

	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(new FraudDetectionController(null));
	}
}
