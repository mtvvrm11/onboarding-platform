package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Course;
import org.example.repository.CourseRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * service for course management.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional(readOnly = true)
    @Cacheable(value = "courses", key = "#id", unless = "#result == null")
    public Course findByIdWithModulesAndLessons(Long id) {
        log.info("fetching course with modules and lessons: id={}", id);
        return courseRepository.findByIdWithModulesAndLessons(id)
                .orElseThrow(() -> new RuntimeException("course not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}