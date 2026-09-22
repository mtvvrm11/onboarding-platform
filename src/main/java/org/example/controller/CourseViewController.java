package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Course;
import org.example.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
 * view controller for courses.
 */
@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseViewController {

    private final CourseService courseService;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "courses/list";
    }

    @GetMapping("/{id}")
    public String viewCourse(@PathVariable Long id, Model model) {
        Course course = courseService.findByIdWithModulesAndLessons(id);
        model.addAttribute("course", course);
        return "courses/view";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/form";
    }

    @PostMapping
    public String createCourse(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.findByIdWithModulesAndLessons(id));
        return "courses/form";
    }

    @PostMapping("/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute Course course) {
        course.setId(id);
        courseService.save(course);
        return "redirect:/courses";
    }

    @PostMapping("/{id}/delete")
    public String deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
        return "redirect:/courses";
    }
}