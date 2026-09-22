package org.example.repository;

import org.example.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * jpa repository for tests.
 */
@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findByModuleId(Long moduleId);
}