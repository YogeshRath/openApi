package com.mastercard.openapi.pojo;

public class LocalSearchFPANRequest {

	private String ahiId;
	private String fiConsumerId;
	private String accountId;
	private String ica;

	public String getAhiId() {
		return ahiId;
	}

	public void setAhiId(String ahiId) {
		this.ahiId = ahiId;
	}

	public String getFiConsumerId() {
		return fiConsumerId;
	}

	public void setFiConsumerId(String fiConsumerId) {
		this.fiConsumerId = fiConsumerId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getIca() {
		return ica;
	}

	public void setIca(String ica) {
		this.ica = ica;
	}

	@Override
	public String toString() {
		return "SearchFPANRequest [ahiId=" + ahiId + ", fiConsumerId=" + fiConsumerId + ", accountId=" + accountId
				+ ", ica=" + ica + "]";
	}

}
