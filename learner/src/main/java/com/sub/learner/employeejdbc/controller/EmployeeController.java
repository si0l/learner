package com.sub.learner.employeejdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sub.learner.employeejdbc.model.Employee;
import com.sub.learner.employeejdbc.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employeeTest() {
        return "Hi, this is Employee application 6";
    }

    @RequestMapping(value = "/employee/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    @RequestMapping(value = "/employee/insertemployee", method = RequestMethod.POST)
    public void insertEmployee(@RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
    }
}
