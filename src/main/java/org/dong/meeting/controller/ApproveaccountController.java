package org.dong.meeting.controller;

import org.dong.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ApproveaccountController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/approveaccount")
    public String approveaccount(Model model){
        model.addAttribute("emps",employeeService.getAllEmpsByStatus(0));
        return "approveaccount";
    }

    @RequestMapping("/updatestatus")
    public String updatestatus(Integer employeeId, Integer status){
        Integer result = employeeService.updatestatus(employeeId,status);
        return "redirect:/admin/approveaccount";
    }
}
