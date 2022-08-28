package com.timeandspacehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.timeandspacehub.dto.HealthInsuranceResponse;
import com.timeandspacehub.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Put class name and column name that was mapped not table name.
	// Pass values correctly in proper order to the constructor
	@Query("SELECT new com.timeandspacehub.dto.HealthInsuranceResponse( emp.id, emp.firstName, emp.lastName, emhi.compositeKey.insuranceId, emhi.compositeKey.providerId, emhi.planName) "
			+ " FROM Employee emp, EmpHealthInsurance emhi WHERE emp.id = emhi.compositeKey.empid and emp.id = :id")
	public List<HealthInsuranceResponse> getBasicHealthInfo(int id);
}
