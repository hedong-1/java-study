package org.dong.meeting.mapper;

import org.apache.ibatis.annotations.Param;
import org.dong.meeting.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    Employee loadEmpByUsername(String username);

    Integer doReg(Employee employee);

    List<Employee> getAllEmpsByStatus(Integer status);

    Integer approveaccount(@Param("employeeId") Integer employeeId,@Param("status") Integer status);

    List<Employee> getAllEmps(@Param("emp") Employee employee, @Param("page") Integer page,@Param("pagesize") Integer pageSize);

    Long getTotal(Employee employee);

    Integer closeEmp(Integer id);

    List<Employee> getEmpByDepId(Integer depId);
}
