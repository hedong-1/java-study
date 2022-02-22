package org.dong.meeting.controller;

import org.dong.meeting.model.Employee;
import org.dong.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EmployeeController {
    public static final Integer PAGE_SIZE = 5;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/searchemployees")
    public String getAllEmployees(Employee employee, @RequestParam(defaultValue = "1") Integer page, Model model){
        List<Employee> emps = employeeService.getAllEmps(employee,page,PAGE_SIZE);
        model.addAttribute("emps",emps);
        Long total = employeeService.getTotal(employee);
        model.addAttribute("total",total);
        model.addAttribute("page",page);
        model.addAttribute("pageNumber",total%PAGE_SIZE == 0?total/PAGE_SIZE:total/PAGE_SIZE+1);
        return "searchemployees";
    }

    @RequestMapping("/closeemp")
    public String updateemp(Integer id){
        Integer result = employeeService.closeEmp(id);
        return "redirect:/admin/searchemployees?status=2";
    }
}
