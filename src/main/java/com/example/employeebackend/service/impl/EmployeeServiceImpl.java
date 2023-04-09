package com.example.employeebackend.service.impl;

import com.example.employeebackend.exception.ResourceNotFoundException;
import com.example.employeebackend.model.Employee;
import com.example.employeebackend.repository.EmployeeRepository;
import com.example.employeebackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
    }

    @Override
    public Employee updateEmployee(UUID employeeId, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhone(employeeDetails.getPhone());
        employee.setJobTitle(employeeDetails.getJobTitle());
        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }
}
