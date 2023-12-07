package com.multidisplinary.project_management.WebPageControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multidisplinary.project_management.Repositories.HRItemRepository;

@Controller
public class HRItemsWebController {

    private final HRItemRepository hRItemRepository;

    public HRItemsWebController(HRItemRepository hRItemRepository) {
        this.hRItemRepository = hRItemRepository;
    }

    @GetMapping("/items")
    public ModelAndView itemsPage() {
        ModelAndView modelAndView = new ModelAndView("items");

        return modelAndView;
    }
}
