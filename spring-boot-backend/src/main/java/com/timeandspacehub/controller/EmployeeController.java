package com.timeandspacehub.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timeandspacehub.exception.ResourceNotFoundException;
import com.timeandspacehub.model.Employee;
import com.timeandspacehub.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	// get all emplooyee

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found:" + id));

		return ResponseEntity.ok(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id,
			@RequestBody Employee employee) {

		Employee employeeToUpdate = this.employeeRepository.findById(id).orElseThrow(

				() -> new ResourceNotFoundException("Employee not found:" + id)

		);

		if (employee.getFirstName() != null) {
			employeeToUpdate.setFirstName(employee.getFirstName());
		}

		if (employee.getLastName() != null) {
			employeeToUpdate.setLastName(employee.getLastName());
		}

		if (employee.getEmailId() != null) {
			employeeToUpdate.setEmailId(employee.getEmailId());
		}

		Employee updatedEmployee = this.employeeRepository.save(employeeToUpdate);
		return ResponseEntity.ok(updatedEmployee);

	}
	
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(value = "id") Long id) {

		Employee employeeToDelete = this.employeeRepository.findById(id).orElseThrow(

				() -> new ResourceNotFoundException("Employee not found:" + id)

		);


		this.employeeRepository.delete(employeeToDelete);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
