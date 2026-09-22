package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * home page controller.
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CourseService courseService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "index";
    }
}