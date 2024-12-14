package com.yogesh.jpa_rest.controller;

import com.yogesh.jpa_rest.model.Employee;
import com.yogesh.jpa_rest.model.EmployeeDTO;
import com.yogesh.jpa_rest.model.EmployeeNotFoundException;
import com.yogesh.jpa_rest.service.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/employees")
    void receivePostRequest(@RequestBody EmployeeDTO employeeDTO) {
        System.out.println("received request " + employeeDTO.toString());
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getRole() );
        employeeRepository.save(employee);
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @GetMapping("/employees/{id}")
    Employee getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}
