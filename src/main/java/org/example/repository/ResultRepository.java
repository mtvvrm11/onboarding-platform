package org.example.repository;

import org.example.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * jpa repository for test results.
 */
@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByUserId(Long userId);
}