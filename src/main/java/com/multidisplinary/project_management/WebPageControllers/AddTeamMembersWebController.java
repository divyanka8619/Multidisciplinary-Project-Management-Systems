package com.multidisplinary.project_management.WebPageControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multidisplinary.project_management.Repositories.AddTeamMembersRepository;

@Controller
public class AddTeamMembersWebController {

    private final AddTeamMembersRepository addTeamMembersRepository;

    public AddTeamMembersWebController(AddTeamMembersRepository addTeamMembersRepository) {
        this.addTeamMembersRepository = addTeamMembersRepository;
    }

    @GetMapping("/members")
    public ModelAndView membersPage() {
        ModelAndView modelAndView = new ModelAndView("members");

        return modelAndView;
    }
}
