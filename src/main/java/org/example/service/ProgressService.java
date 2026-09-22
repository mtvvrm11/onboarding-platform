package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Course;
import org.example.entity.Progress;
import org.example.entity.User;
import org.example.repository.CourseRepository;
import org.example.repository.ProgressRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/*
 * service for tracking user progress.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProgressService {

    private final ProgressRepository progressRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public Progress startCourse(Long userId, Long courseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("course not found"));

        Progress progress = progressRepository.findByUserIdAndCourseId(userId, courseId)
                .orElseGet(Progress::new);

        progress.setUser(user);
        progress.setCourse(course);
        progress.setStatus("IN_PROGRESS");
        progress.setStartedAt(LocalDateTime.now());

        return progressRepository.save(progress);
    }

    @Transactional
    public Progress updateProgress(Long userId, Long courseId, int completedPercent) {
        Progress progress = progressRepository.findByUserIdAndCourseId(userId, courseId)
                .orElseThrow(() -> new RuntimeException("progress not found"));

        progress.setCompletedPercent(completedPercent);

        if (completedPercent >= 100) {
            progress.setStatus("COMPLETED");
            progress.setCompletedAt(LocalDateTime.now());
        }

        return progressRepository.save(progress);
    }

    @Transactional(readOnly = true)
    public List<Progress> getUserProgress(Long userId) {
        return progressRepository.findByUserId(userId);
    }
}