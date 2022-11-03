package com.sub.learner.employee.service;

import java.util.List;

import com.sub.learner.employee.model.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void insertEmployee(Employee employee);

}