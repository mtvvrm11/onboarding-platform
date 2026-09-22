package org.example.repository;

import org.example.entity.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * jpa repository for courses.
 * uses join fetch to avoid n+1 problem.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @EntityGraph(attributePaths = {"modules", "modules.lessons"})
    @Query("select c from Course c where c.id = :id")
    Optional<Course> findByIdWithModulesAndLessons(@Param("id") Long id);

    List<Course> findByMandatory(Boolean mandatory);
}