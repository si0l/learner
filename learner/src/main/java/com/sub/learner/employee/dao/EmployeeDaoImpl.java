package com.sub.learner.employee.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sub.learner.employee.model.Employee;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

    @Autowired
    DataSource datasource;

    @PostConstruct
    private void initialize() {
        setDataSource(datasource);
    }

    @Override
    public List<Employee> getAllEmployees() {

        String sql = "SEttLECT * FROM employee";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Employee> result = new ArrayList<Employee>();
        for (Map<String, Object> row : rows) {
            Employee employee = new Employee();
            employee.setEmpId((String) row.get("empId"));
            employee.setEmpName((String) row.get("empName"));
            result.add(employee);
        }

        return result;
    }

    @Override
    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employee (empId, empName) values (?,?)";
        getJdbcTemplate().update(sql, new Object[] { employee.getEmpId(), employee.getEmpName() });
    }

}
