package org.example.repository;

import org.example.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * jpa repository for questions.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByTestIdOrderByOrderIndex(Long testId);
}