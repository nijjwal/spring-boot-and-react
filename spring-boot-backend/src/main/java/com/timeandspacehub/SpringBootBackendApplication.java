package com.timeandspacehub;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.timeandspacehub.model.EmpHealthInsurance;
import com.timeandspacehub.model.EmpHealthInsuranceIdentity;
import com.timeandspacehub.repository.EmpHealthInsuranceRepository;

@SpringBootApplication
public class SpringBootBackendApplication implements CommandLineRunner {

	@Autowired
	private EmpHealthInsuranceRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Cleanp up all the tables
		// employeeRepository.deleteAllInBatch();

		// Create object and insert in db
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		//Set Composite Key Value 
		EmpHealthInsuranceIdentity pk = new EmpHealthInsuranceIdentity(24, 123456, 1);
		
		//Create record for EMP_HEALTH_INSURANCE table.
		EmpHealthInsurance empHealthInsurance = new EmpHealthInsurance(pk, timestamp,
				"Cobra", 150.50, 10.50);
		employeeRepository.save(empHealthInsurance);

	}

}
