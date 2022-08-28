package com.timeandspacehub.dto;

public class HealthInsuranceResponse {

	private int id;
	private String firstName;
	private String lastName;
	private int insuranceId;
	private int providerId;
	private String planName;

	public int getId() {
		return id;
	}

	public HealthInsuranceResponse() {
		
	}
	
	public HealthInsuranceResponse(int id, String firstName, String lastName, int insuranceId, int providerId,
			String planName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.insuranceId = insuranceId;
		this.providerId = providerId;
		this.planName = planName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

}
