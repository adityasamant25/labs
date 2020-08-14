package com.example.httpserver.model;

import java.io.Serializable;

public class FraudCheck implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3866296885152580663L;
	private String clientId;
	long loanAmount;

	public FraudCheck() {
		super();
	}

	public FraudCheck(String clientId, long loanAmount) {
		super();
		this.clientId = clientId;
		this.loanAmount = loanAmount;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	@Override
	public String toString() {
		return "FraudCheck [clientId=" + clientId + ", loanAmount=" + loanAmount + "]";
	}
	
	
}
