package com.example.httpserver.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.httpserver.model.FraudCheck;
import com.example.httpserver.model.FraudCheckResult;
import com.example.httpserver.model.FraudCheckStatus;

@RestController
public class FraudCheckController {

	public FraudCheckController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PutMapping(value = "/fraudcheck")
	public FraudCheckResult fraudCheck(@RequestBody FraudCheck fraudCheck) {
		if (amountGreaterThanThreshold(fraudCheck)) {
		    return new FraudCheckResult(FraudCheckStatus.FRAUD, "Amount too high");
		}
		return new FraudCheckResult(FraudCheckStatus.OK, null);
	}

	private boolean amountGreaterThanThreshold(FraudCheck fraudCheck) {
		return fraudCheck.getLoanAmount() > 10000;
	}
}
