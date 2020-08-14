package com.example.httpclient.model;

import java.io.Serializable;

public class FraudCheckResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4852228099657028082L;

	private String fraudCheckStatus;
	
	private String rejectionReason;

	public FraudCheckResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FraudCheckResult(String fraudCheckStatus, String rejectionReason) {
		super();
		this.fraudCheckStatus = fraudCheckStatus;
		this.rejectionReason = rejectionReason;
	}

	public String getFraudCheckStatus() {
		return fraudCheckStatus;
	}

	public void setFraudCheckStatus(String fraudCheckStatus) {
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
