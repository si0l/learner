package com.sub.learner.employee.dao;

import java.util.List;
import com.sub.learner.employee.model.Employee;

public interface EmployeeDao {
    List<Employee> getAllEmployees();

    void insertEmployee(Employee employee);
}