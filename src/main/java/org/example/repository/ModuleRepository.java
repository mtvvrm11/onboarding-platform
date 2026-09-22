package org.example.repository;

import org.example.entity.Module;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * jpa repository for modules.
 */
@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    @EntityGraph(attributePaths = {"lessons"})
    @Query("select m from Module m where m.id = :id")
    Optional<Module> findByIdWithLessons(@Param("id") Long id);

    List<Module> findByCourseIdOrderByOrderIndex(Long courseId);
}