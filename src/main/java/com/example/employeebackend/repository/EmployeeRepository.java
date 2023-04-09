package com.example.employeebackend.repository;

import com.example.employeebackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findById(UUID employeeId);
}
