package com.sub.learner.employeejdbc.model;

public class Employee {

    private String empId;
    private String empName;

    public Employee() {
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    @Override
    public String toString() {
        return "Employee [empId= " + empId + ", empName" + empName + "]";
    }

}