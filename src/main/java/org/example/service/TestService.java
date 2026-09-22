package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Result;
import org.example.entity.Test;
import org.example.entity.User;
import org.example.repository.ResultRepository;
import org.example.repository.TestRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * service for tests and results.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    private final ResultRepository resultRepository;
    private final UserRepository userRepository;

    @Transactional
    public Result submitResult(Long userId, Long testId, int score) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new RuntimeException("test not found"));

        boolean passed = score >= test.getPassingScore();

        Result result = new Result();
        result.setUser(user);
        result.setTest(test);
        result.setScore(score);
        result.setPassed(passed);

        return resultRepository.save(result);
    }

    @Transactional(readOnly = true)
    public List<Result> getUserResults(Long userId) {
        return resultRepository.findByUserId(userId);
    }
}