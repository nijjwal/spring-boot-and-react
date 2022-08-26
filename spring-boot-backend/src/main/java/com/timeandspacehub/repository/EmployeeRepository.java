package com.timeandspacehub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.timeandspacehub.model.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
