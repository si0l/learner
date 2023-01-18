package com.sub.learner.employeejdbc.dao;

import java.util.List;

import com.sub.learner.employeejdbc.model.Employee;

public interface EmployeeDao {
    List<Employee> getAllEmployees();

    void insertEmployee(Employee employee);
}