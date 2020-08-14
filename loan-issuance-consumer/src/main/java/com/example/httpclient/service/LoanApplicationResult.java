package com.example.httpclient.service;

public class LoanApplicationResult {

	private LoanApplicationStatus status;
	private String rejectionReason;

	public LoanApplicationResult(LoanApplicationStatus status) {
		this.status = status;
	}

	public LoanApplicationResult(LoanApplicationStatus status, String rejectionReason) {
		this.status = status;
		this.rejectionReason = rejectionReason;
	}

	public LoanApplicationStatus getLoanApplicationStatus() {
		return this.status;
	}

	public String getRejectionReason() {
		return this.rejectionReason;
	}

}
