package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/*
 * spring boot entry point for vels onboarding platform.
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
public class VelsOnboardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(VelsOnboardingApplication.class, args);
    }
}