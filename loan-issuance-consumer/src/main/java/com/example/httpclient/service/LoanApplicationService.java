package com.example.httpclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.httpclient.model.FraudCheckResult;
import com.example.httpclient.model.LoanApplication;

@Service
public class LoanApplicationService {

	private RestTemplate restTemplate;

	@Autowired
	public LoanApplicationService(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	private final int port = 8080;

	public LoanApplicationResult loanApplication(LoanApplication application) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<FraudCheckResult> response = restTemplate.exchange("http://localhost:" + port + "/fraudcheck",
				HttpMethod.PUT, new HttpEntity<>(application, headers), FraudCheckResult.class);
		System.out.println("Response: " + response.toString());

		return new LoanApplicationResult("FRAUD".equalsIgnoreCase(response.getBody().getFraudCheckStatus())
				? LoanApplicationStatus.LOAN_APPLICATION_REJECTED
				: LoanApplicationStatus.LOAN_APPLICATION_APPROVED, response.getBody().getRejectionReason());
	}
}
