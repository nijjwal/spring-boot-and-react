package com.timeandspacehub.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "emp_health_insurance")
public class EmpHealthInsurance {

	@EmbeddedId
	private EmpHealthInsuranceIdentity compositeKey;

	@Column(name = "health_ins_start_date")
	private Timestamp startDate;

	@Column(name = "health_ins_plan_name")
	private String planName;

	@Column(name = "health_ins_comp_contribution")
	private double compContribution;

	@Column(name = "health_ins_monthly_fee")
	private double monthlyFee;
	
	public EmpHealthInsurance() {
		
	}

	public EmpHealthInsurance(EmpHealthInsuranceIdentity compositeKey, Timestamp startDate, String planName,
			double compContribution, double monthlyFee) {
		super();
		this.compositeKey = compositeKey;
		this.startDate = startDate;
		this.planName = planName;
		this.compContribution = compContribution;
		this.monthlyFee = monthlyFee;
	}

	public EmpHealthInsuranceIdentity getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(EmpHealthInsuranceIdentity compositeKey) {
		this.compositeKey = compositeKey;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public double getCompContribution() {
		return compContribution;
	}

	public void setCompContribution(double compContribution) {
		this.compContribution = compContribution;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

}
