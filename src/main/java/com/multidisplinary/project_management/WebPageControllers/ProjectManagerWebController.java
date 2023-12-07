package com.multidisplinary.project_management.WebPageControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multidisplinary.project_management.Repositories.ProjectManagerRepository;

@Controller
public class ProjectManagerWebController {

    private final ProjectManagerRepository projectManagerRepository;

    public ProjectManagerWebController(ProjectManagerRepository projectManagerRepository) {
        this.projectManagerRepository = projectManagerRepository;
    }

    @GetMapping("/projects")
    public ModelAndView projectsPage() {
        ModelAndView modelAndView = new ModelAndView("projects");

        return modelAndView;
    }
}
