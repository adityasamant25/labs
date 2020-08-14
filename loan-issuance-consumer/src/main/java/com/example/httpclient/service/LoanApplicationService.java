package com.example.httpclient.service;

import org.springframework.stereotype.Service;

import com.example.httpclient.model.LoanApplication;

@Service
public class LoanApplicationService {

	public LoanApplicationResult loanApplication(LoanApplication application) {
		return new LoanApplicationResult(LoanApplicationStatus.LOAN_APPLICATION_REJECTED, "Amount too high");
	}
}
