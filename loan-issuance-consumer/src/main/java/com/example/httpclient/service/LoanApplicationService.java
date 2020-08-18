package com.example.httpclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${fraud.service.protocol:http}")
	private String fraudDetectionServiceProtocol;
	
	@Value("${fraud.service.servicename:localhost}")
	private String fraudDetectionServiceName;
	
	@Value("${fraud.service.port:8080}")
	private String fraudDetectionServicePort;

	private RestTemplate restTemplate;

	@Autowired
	public LoanApplicationService(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public LoanApplicationResult loanApplication(LoanApplication application) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<FraudCheckResult> response = restTemplate.exchange(fraudDetectionServiceProtocol + "://" + fraudDetectionServiceName + ":" + fraudDetectionServicePort + "/fraudcheck",
				HttpMethod.PUT, new HttpEntity<>(application, headers), FraudCheckResult.class);

		return new LoanApplicationResult("FRAUD".equalsIgnoreCase(response.getBody().getFraudCheckStatus())
				? LoanApplicationStatus.LOAN_APPLICATION_REJECTED
				: LoanApplicationStatus.LOAN_APPLICATION_APPROVED, response.getBody().getRejectionReason());
	}
}
