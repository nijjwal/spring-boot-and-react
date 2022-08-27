package com.timeandspacehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timeandspacehub.model.EmpHealthInsurance;
import com.timeandspacehub.model.EmpHealthInsuranceIdentity;

@Repository
public interface EmpHealthInsuranceRepository extends JpaRepository<EmpHealthInsurance, EmpHealthInsuranceIdentity>{

}
