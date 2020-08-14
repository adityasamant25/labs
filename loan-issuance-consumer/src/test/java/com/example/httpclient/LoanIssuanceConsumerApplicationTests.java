package com.example.httpclient;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import com.example.httpclient.model.LoanApplication;
import com.example.httpclient.service.LoanApplicationResult;
import com.example.httpclient.service.LoanApplicationService;
import com.example.httpclient.service.LoanApplicationStatus;

@SpringBootTest
@AutoConfigureStubRunner(ids = {
		"com.example:http-server:0.0.1-SNAPSHOT:stubs:8080" }, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class LoanIssuanceConsumerApplicationTests {

	@Autowired
	LoanApplicationService service;

	@Test
	void contextLoads() {
	}

	@Test
	public void shouldBeRejectedDueToAbnormalLoanAmount() {
		// given:
		LoanApplication application = new LoanApplication("1234567890", 99999);

		// when:
		LoanApplicationResult loanApplication = service.loanApplication(application);

		// then:
		assertThat(loanApplication.getLoanApplicationStatus())
				.isEqualTo(LoanApplicationStatus.LOAN_APPLICATION_REJECTED);
		assertThat(loanApplication.getRejectionReason()).isEqualTo("Amount too high");
	}

}
