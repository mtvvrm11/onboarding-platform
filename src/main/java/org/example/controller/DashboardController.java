package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.CourseService;
import org.example.service.ProgressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * dashboard controller for user cabinet.
 */
@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final CourseService courseService;
    private final ProgressService progressService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("progress", progressService.getUserProgress(1L));
        return "dashboard";
    }
}