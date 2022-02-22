package org.dong.meeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class NotificationController {
    @RequestMapping("/notifications")
    public String notifications(){
        return "notifications";
    }
}
