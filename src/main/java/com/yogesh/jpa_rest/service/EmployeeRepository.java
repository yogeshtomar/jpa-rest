package com.yogesh.jpa_rest.service;

import com.yogesh.jpa_rest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
