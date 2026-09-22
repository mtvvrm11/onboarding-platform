package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.CourseService;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * admin dashboard controller.
 */
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final CourseService courseService;
    private final UserService userService;

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("users", userService.findAll());
        return "admin/dashboard";
    }
}