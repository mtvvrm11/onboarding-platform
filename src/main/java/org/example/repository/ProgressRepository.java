package org.example.repository;

import org.example.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * jpa repository for progress.
 */
@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

    Optional<Progress> findByUserIdAndCourseId(Long userId, Long courseId);

    List<Progress> findByUserId(Long userId);
}