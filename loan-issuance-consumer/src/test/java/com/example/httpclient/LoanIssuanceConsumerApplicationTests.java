package com.example.httpclient;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.httpclient.model.Client;
import com.example.httpclient.model.LoanApplication;
import com.example.httpclient.service.LoanApplicationResult;
import com.example.httpclient.service.LoanApplicationService;
import com.example.httpclient.service.LoanApplicationStatus;

@SpringBootTest
class LoanIssuanceConsumerApplicationTests {

	@Autowired
	LoanApplicationService service;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void shouldBeRejectedDueToAbnormalLoanAmount() {
		// given:
		LoanApplication application = new LoanApplication(new Client("1234567890"), 99999);
		
		
		// when:
		LoanApplicationResult loanApplication = service.loanApplication(application);
		
		// then:
		assertThat(loanApplication.getLoanApplicationStatus()).isEqualTo(LoanApplicationStatus.LOAN_APPLICATION_REJECTED);
		assertThat(loanApplication.getRejectionReason()).isEqualTo("Amount too high");
	}

}
