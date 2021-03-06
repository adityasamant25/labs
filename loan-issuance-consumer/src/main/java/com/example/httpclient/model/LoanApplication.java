package com.example.httpclient.model;

import java.io.Serializable;

public class LoanApplication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7838530803492100939L;
	private String clientId;
	long loanAmount;

	public LoanApplication() {
		super();
	}

	public LoanApplication(String clientId, long loanAmount) {
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
		return "LoanApplication [clientId=" + clientId + ", loanAmount=" + loanAmount + "]";
	}

}
