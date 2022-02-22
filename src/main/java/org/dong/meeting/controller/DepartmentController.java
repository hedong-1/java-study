package org.dong.meeting.controller;

import org.dong.meeting.model.Department;
import org.dong.meeting.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping ("/departments")
    public String departments(Model model){
        model.addAttribute("deps",departmentService.getAllDeps());
        return "departments";
    }

    @RequestMapping("/adddepartment")
    public String adddepartment(String departmentName){
        Integer result = departmentService.addDepartment(departmentName);
        return "redirect:/admin/departments";
    }

    @RequestMapping("/deletedep")
    public String deletedep(Integer departmentId){
        departmentService.deleteDepById(departmentId);
        return "redirect:/admin/departments";
    }

    @RequestMapping("/updatedep")
    @ResponseBody
    public String updatedep(Integer id, String name){
        Integer result = departmentService.updateDep(id,name);
        if (result==1){
            return "success";
        }
        return "error";
    }
}
