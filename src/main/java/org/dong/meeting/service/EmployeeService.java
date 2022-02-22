package org.dong.meeting.service;

import org.dong.meeting.mapper.EmployeeMapper;
import org.dong.meeting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public Employee doLogin(String username, String password) {
        Employee employee = employeeMapper.loadEmpByUsername(username);
        if (employee == null || !employee.getPassword().equals(password)){
            return null;
        }
        return employee;
    }

    public Integer deReg(Employee employee) {
        Employee emp = employeeMapper.loadEmpByUsername(employee.getUsername());
        if (emp != null){
            return -1;
        }
        employee.setRole(1);
        employee.setStatus(0);
        return employeeMapper.doReg(employee);
    }

    public List<Employee> getAllEmpsByStatus(Integer status) {
        return employeeMapper.getAllEmpsByStatus(status);
    }

    public Integer updatestatus(Integer employeeId, Integer status) {
        return employeeMapper.approveaccount(employeeId,status);
    }

    public List<Employee> getAllEmps(Employee employee, Integer page, Integer pageSize) {
        page = (page-1) * pageSize;
        return employeeMapper.getAllEmps(employee,page,pageSize);
    }

    public Long getTotal(Employee employee) {
        return employeeMapper.getTotal(employee);
    }

    public Integer closeEmp(Integer id) {
        return employeeMapper.closeEmp(id);
    }

    public List<Employee> getEmpByDepId(Integer depId) {
        return employeeMapper.getEmpByDepId(depId);
    }
}
