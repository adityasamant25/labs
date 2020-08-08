package com.example.frauddetection;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FraudDetectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FraudDetectionApplication.class, args);
	}

}

@RestController
class FraudDetectionController {
	
	@GetMapping("/frauds")
	ResponseEntity<List<String>> frauds() {
		return ResponseEntity.status(200).body(Arrays.asList("marcin", "josh"));
	}
}
