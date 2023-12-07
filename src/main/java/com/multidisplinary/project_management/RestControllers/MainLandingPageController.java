package com.multidisplinary.project_management.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.multidisplinary.project_management.Services.ProjectManagerService;
import com.multidisplinary.project_management.Services.StatusOfEmployeeService;
import com.multidisplinary.project_management.Services.AddTeamMembersService;

@Controller
public class MainLandingPageController {

    @Autowired
    ProjectManagerService projectManagerService;

    @Autowired
    StatusOfEmployeeService statusOfEmployeeService;

    @Autowired
    AddTeamMembersService addTeamMembersService;

    @GetMapping("/")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView("main_page");

        return modelAndView;
    }
}
