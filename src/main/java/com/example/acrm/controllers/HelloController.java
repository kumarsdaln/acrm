package com.example.acrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String home(Model model) {
        String[] blogs = {"blog1", "blog2", "blog3", "blog4", "blog5"};
        model.addAttribute("blogs", blogs);

        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/services")
    public String services() {
        return "services";
    }
}
