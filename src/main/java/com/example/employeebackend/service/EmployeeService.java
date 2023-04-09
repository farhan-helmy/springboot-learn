package com.example.employeebackend.service;

import com.example.employeebackend.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(UUID employeeId);
    Employee updateEmployee(UUID employeeId, Employee employeeDetails);
}
