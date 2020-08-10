package com.example.carrental;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

@SpringBootTest
@AutoConfigureStubRunner(ids = "com.example:fraud-detection", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class FraudListenerTests {

	@Autowired
	FraudListener fraudListener;
	
	@Autowired
	StubTrigger stubTrigger;
	
	@Test
	public void should_store_a_fraud() {
		
		//when a message is sent
		this.stubTrigger.trigger("trigger_fraud");
		
		//then we store a fraud
		
		BDDAssertions.then(this.fraudListener.fraud).isNotNull();
		BDDAssertions.then(this.fraudListener.fraud.surname).isEqualTo("m");
		
	}
}
