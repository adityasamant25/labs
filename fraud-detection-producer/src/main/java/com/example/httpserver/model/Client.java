package com.example.httpserver.model;

import java.io.Serializable;

public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8046427357558677790L;
	
	private String clientId;
	long loanAmount;

	public Client() {
		super();
	}

	public Client(String clientId, long loanAmount) {
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
		return "Client [clientId=" + clientId + ", loanAmount=" + loanAmount + "]";
	}
	
	

}
