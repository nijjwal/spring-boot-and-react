package com.timeandspacehub.dto;

import com.timeandspacehub.model.Employee;

/**
 * If you want to add more fields or classes in the future, this class can be
 * used without breaking the requesting API's method.
 * 
 * @author nijjwalshrestha
 *
 */
public class HealthInsuranceRequest {

	private Employee employee;

	public HealthInsuranceRequest() {

	}

	public HealthInsuranceRequest(Employee employee) {
		super();
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "HealthInsuranceRequest [employee=" + employee + ", getEmployee()=" + getEmployee() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
