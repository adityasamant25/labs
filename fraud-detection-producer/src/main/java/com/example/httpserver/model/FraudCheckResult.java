package com.example.httpserver.model;

import java.io.Serializable;

public class FraudCheckResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4489028476179058495L;

	/**
	 * 
	 */

	private FraudCheckStatus fraudCheckStatus;

	private String rejectionReason;

	public FraudCheckResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FraudCheckResult(FraudCheckStatus fraudCheckStatus, String rejectionReason) {
		super();
		this.fraudCheckStatus = fraudCheckStatus;
		this.rejectionReason = rejectionReason;
	}

	public FraudCheckStatus getFraudCheckStatus() {
		return fraudCheckStatus;
	}

	public void setFraudCheckStatus(FraudCheckStatus fraudCheckStatus) {
		this.fraudCheckStatus = fraudCheckStatus;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	@Override
	public String toString() {
		return "FraudCheckResult [fraudCheckStatus=" + fraudCheckStatus + ", rejectionReason=" + rejectionReason + "]";
	}

}