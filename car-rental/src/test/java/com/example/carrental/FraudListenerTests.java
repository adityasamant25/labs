package com.example.carrental;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootTest
public class FraudListenerTests {

	@Autowired
	FraudListener fraudListener;
	
	@Autowired
	Sink sink;
	
	@Test
	public void should_store_a_fraud() {
		//given a fraud
		Fraud fraud = new Fraud("m");
		//when a message is sent
		this.sink.input().send(MessageBuilder.withPayload(fraud).build());
		
		//then we store a fraud
		
		BDDAssertions.then(this.fraudListener.fraud).isNotNull();
		BDDAssertions.then(this.fraudListener.fraud.surname).isEqualTo("m");
		
	}
}
