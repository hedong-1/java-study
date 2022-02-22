package org.dong.meeting.controller;

import org.dong.meeting.model.Department;
import org.dong.meeting.model.Employee;
import org.dong.meeting.model.Meeting;
import org.dong.meeting.service.DepartmentService;
import org.dong.meeting.service.EmployeeService;
import org.dong.meeting.service.MeetingRoomService;
import org.dong.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MeetingController {
    @Autowired
    MeetingRoomService meetingRoomService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MeetingService meetingService;

    @RequestMapping("/bookmeeting")
    public String bookmeeting(Model model){
        model.addAttribute("mrs",meetingRoomService.getAllMr());
        return "bookmeeting";
    }

    @RequestMapping("/alldeps")
    @ResponseBody
    public List<Department> getAllDeps(){
        return departmentService.getAllDeps();
    }

    @RequestMapping("/getempbydepid")
    @ResponseBody
    public List<Employee> getEmpByDepId(Integer depId){
        return employeeService.getEmpByDepId(depId);
    }

    @RequestMapping("/doAddMeeting")
    public String doAddMeeting(Meeting meeting, Integer[] mps, HttpSession httpSession){
        Employee currentUser = (Employee) httpSession.getAttribute("currentUser");
        meeting.setReservationistId(currentUser.getEmployeeId());
        Integer result = meetingService.addMeeting(meeting,mps);
        if (result == 1) {
            return "redirect:/searchmeetings";
        } else {
            return "forward:/bookmeeting";
        }
    }

    @RequestMapping("/searchmeetings")
    public String searchmeetings(){
        return "searchmeetings";
    }

}
