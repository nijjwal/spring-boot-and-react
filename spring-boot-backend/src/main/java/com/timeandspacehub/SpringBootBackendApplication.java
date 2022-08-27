package com.timeandspacehub;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.timeandspacehub.model.EmpHealthInsurance;
import com.timeandspacehub.model.EmpHealthInsuranceIdentity;
import com.timeandspacehub.model.Employee;
import com.timeandspacehub.repository.EmpHealthInsuranceRepository;
import com.timeandspacehub.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootBackendApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmpHealthInsuranceRepository empHealthInsuranceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Sample One-to-Many Relationship - STARTS
		
		// 1. Cleanup all the data in both EMPLOYEES and EMP_HEALTH_INSURANCE table in
		// proper order.
		empHealthInsuranceRepository.deleteAllInBatch();
		employeeRepository.deleteAllInBatch();

		// 2. Create new employee for EMPLOYEES table and insert in db
		Employee newEmp = new Employee("Chuck", "Norris", "chucknorris@gmail.com");
		Employee savedEmployee = employeeRepository.save(newEmp);

		// 3. Set Composite Key Value for EMP_HEALTH_INSURANCE table.
		EmpHealthInsuranceIdentity pk = new EmpHealthInsuranceIdentity(savedEmployee.getId(), 123456, 1);
		Timestamp currDateAndTime = new Timestamp(System.currentTimeMillis());

		// 4. Create new record in EMP_HEALTH_INSURANCE table for the newly created
		// Employee
		EmpHealthInsurance empHealthInsurance = new EmpHealthInsurance(pk, currDateAndTime, "Cobra", 150.50, 10.50);
		empHealthInsuranceRepository.save(empHealthInsurance);
		
		//Sample One-to-Many Relationship - ENDS

	}

}
