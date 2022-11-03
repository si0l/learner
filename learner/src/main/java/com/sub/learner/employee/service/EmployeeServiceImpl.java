package com.sub.learner.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sub.learner.employee.dao.EmployeeDao;
import com.sub.learner.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeDao.getAllEmployees();
        return employees;
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

}
