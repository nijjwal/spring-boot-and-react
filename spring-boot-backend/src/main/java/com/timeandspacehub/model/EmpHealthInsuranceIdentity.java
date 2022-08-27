package com.timeandspacehub.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpHealthInsuranceIdentity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "emp_id")
	int empId;

	@Column(name = "health_ins_id")
	int insuranceId;

	@Column(name = "health_ins_provider_id")
	int providerId;

	public EmpHealthInsuranceIdentity() {

	}

	public EmpHealthInsuranceIdentity(int empId, int insuranceId, int providerId) {
		super();
		this.empId = empId;
		this.insuranceId = insuranceId;
		this.providerId = providerId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, insuranceId, providerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpHealthInsuranceIdentity other = (EmpHealthInsuranceIdentity) obj;
		return empId == other.empId && insuranceId == other.insuranceId && providerId == other.providerId;
	}

}
