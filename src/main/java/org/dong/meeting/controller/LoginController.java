package org.dong.meeting.controller;

import org.dong.meeting.model.Department;
import org.dong.meeting.model.Employee;
import org.dong.meeting.service.DepartmentService;
import org.dong.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpSession httpSession){
        Employee employee = employeeService.doLogin(username,password);
        if (employee == null){
            model.addAttribute("error","用户名或密码错误，登陆失败");
            return "forward:/";
        }else {
            if (employee.getStatus() == 0){
                model.addAttribute("error","用户待审批");
                return "forward:/";
            }else if (employee.getStatus() == 2){
                model.addAttribute("error","用户审批未通过");
                return "forward:/";
            }else {
                httpSession.setAttribute("currentUser",employee);
                return "redirect:/notifications";
            }
        }
    }

    @RequestMapping("/register")
    public String register(Model model){
        List<Department> deps = departmentService.getAllDeps();
        model.addAttribute("deps",deps);
        return "register";
    }

    @RequestMapping("/doReg")
    public String doReg(Employee employee, Model model){
        Integer result = employeeService.deReg(employee);
        if (result==1){
            return "redirect:/";
        }else {
            model.addAttribute("employee", employee);
            model.addAttribute("error","注册失败，用户名已存在");
            return "forward:/register";
        }
    }
}
