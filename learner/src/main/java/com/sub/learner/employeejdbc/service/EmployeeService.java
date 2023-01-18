package com.sub.learner.employeejdbc.service;

import java.util.List;

import com.sub.learner.employeejdbc.model.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void insertEmployee(Employee employee);

}