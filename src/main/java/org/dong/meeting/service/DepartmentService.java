package org.dong.meeting.service;

import org.dong.meeting.mapper.DepartmentMapper;
import org.dong.meeting.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public Department getDeptById(Integer id) {
        return departmentMapper.getDeptById(id);
    }

    public List<Department> getAllDeps() {
        return departmentMapper.getAllDeps();
    }

    public Integer addDepartment(String departmentName) {
        Department dep = departmentMapper.getDeptByName(departmentName);
        if (dep!= null){
            return -1;
        }
        return departmentMapper.addDepartment(departmentName);
    }

    public Integer deleteDepById(Integer departmentId) {
        return departmentMapper.deleteDepById(departmentId);
    }

    public Integer updateDep(Integer id, String name) {
        return departmentMapper.updateDep(id,name);
    }
}
