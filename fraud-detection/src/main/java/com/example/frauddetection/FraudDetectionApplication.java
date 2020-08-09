package com.example.frauddetection;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Source.class)
public class FraudDetectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FraudDetectionApplication.class, args);
	}

}

@RestController
class FraudDetectionController {
	
	private final Source source;
	
	public FraudDetectionController(Source source) {
		this.source = source;
	}

	@GetMapping("/frauds")
	ResponseEntity<List<String>> frauds() {
		return ResponseEntity.status(200).body(Arrays.asList("marcin", "josh"));
	}
	
	@PostMapping("/trigger")
	void trigger() {
		System.out.println("\n\n\n SENDING OUT FRAUD!\n\n\n");
		this.source.output().send(MessageBuilder.withPayload(new Fraud("m")).build());
		System.out.println("\n\n\n FRAUD CAUGHT IN RABBIT MQ!\n\n\n");
	}
	
}

class Fraud {
	public String surname;

	public Fraud() {
		super();
	}

	public Fraud(String surname) {
		super();
		this.surname = surname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Fraud [surname=" + surname + "]";
	}
	
}

