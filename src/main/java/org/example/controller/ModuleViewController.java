package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Module;
import org.example.repository.ModuleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
 * view controller for modules.
 */
@Controller
@RequestMapping("/modules")
@RequiredArgsConstructor
public class ModuleViewController {

    private final ModuleRepository moduleRepository;

    @GetMapping("/{id}")
    public String viewModule(@PathVariable Long id, Model model) {
        Module module = moduleRepository.findByIdWithLessons(id)
                .orElseThrow(() -> new RuntimeException("module not found"));
        model.addAttribute("module", module);
        return "modules/view";
    }
}