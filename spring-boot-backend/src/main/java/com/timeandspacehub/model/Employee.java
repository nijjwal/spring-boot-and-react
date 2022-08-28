package com.timeandspacehub.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="employees")

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	  
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name="email_id")
	private String emailId;
	
	//@Cascade(CascadeType.SAVE_UPDATE)
	//@OneToMany(targetEntity=EmpHealthInsurance.class, cascade=CascadeType.ALL)
	//@OneToMany(targetEntity=EmpHealthInsurance.class, cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@OneToMany(targetEntity=EmpHealthInsurance.class, cascade=CascadeType.ALL)
	//@OneToMany(targetEntity=EmpHealthInsurance.class, cascade=CascadeType.PERSIST)
	//@OneToMany(targetEntity=EmpHealthInsurance.class, cascade=CascadeType.REFRESH)
	//@OneToMany(targetEntity=EmpHealthInsurance.class, cascade=CascadeType.ALL)
	//@OneToMany(targetEntity=EmpHealthInsurance.class, cascade=CascadeType.REMOVE)
	//@Cascade({ CascadeType.MERGE, CascadeType.LOCK })
	@JoinColumn(name="empid", referencedColumnName="id", nullable=true)
	List<EmpHealthInsurance> listOfInsurance;

	public Employee() {

	}

	public Employee(int id, String firstName, String lastName, String emailId,
			List<EmpHealthInsurance> listOfInsurance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.listOfInsurance = listOfInsurance;
	}

	public int getId() {
		return id;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<EmpHealthInsurance> getListOfInsurance() {
		return listOfInsurance;
	}

	public void setListOfInsurance(List<EmpHealthInsurance> listOfInsurance) {
		this.listOfInsurance = listOfInsurance;
	}

}
