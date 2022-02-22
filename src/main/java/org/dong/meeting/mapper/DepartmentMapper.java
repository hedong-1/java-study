package org.dong.meeting.mapper;

import org.apache.ibatis.annotations.Param;
import org.dong.meeting.model.Department;

import java.util.List;

public interface DepartmentMapper {
    Department getDeptById(Integer id);

    List<Department> getAllDeps();

    Integer addDepartment(String departmentName);

    Department getDeptByName(String departmentName);

    Integer deleteDepById(Integer departmentId);

    Integer updateDep(@Param("id") Integer id,@Param("name") String name);
}
