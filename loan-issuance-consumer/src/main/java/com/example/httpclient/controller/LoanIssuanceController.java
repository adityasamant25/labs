package com.example.httpclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.httpclient.model.LoanApplication;
import com.example.httpclient.service.LoanApplicationResult;
import com.example.httpclient.service.LoanApplicationService;

@RestController
public class LoanIssuanceController {

	@Autowired
	LoanApplicationService service;
	
	@PostMapping(value = "/checkFraud", consumes = "application/json", produces = "application/json")
	public LoanApplicationResult checkFraud(@RequestBody LoanApplication loanApplication) {
		return service.loanApplication(loanApplication);
	}
}
