package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Lesson;
import org.example.repository.LessonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
 * view controller for lessons.
 */
@Controller
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonViewController {

    private final LessonRepository lessonRepository;

    @GetMapping("/{id}")
    public String viewLesson(@PathVariable Long id, Model model) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("lesson not found"));
        model.addAttribute("lesson", lesson);
        return "lessons/view";
    }
}