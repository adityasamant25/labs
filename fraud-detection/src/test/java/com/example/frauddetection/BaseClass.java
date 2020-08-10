package com.example.frauddetection;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMessageVerifier
public class BaseClass {

	@Autowired
	FraudDetectionController fraudDetectionController;
	
	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.fraudDetectionController);
	}
	
	public void trigger() {
		this.fraudDetectionController.trigger();
	}
}
