# vels onboarding platform

educational platform for employee onboarding.

## features

- courses, modules, lessons
- video support (youtube, local)
- tests with questions and answers
- progress tracking
- user roles (admin, hr, mentor, student)
- rest api documented with swagger
- email notifications
- docker support

## tech stack

- java 17
- spring boot 3.2
- spring mvc
- spring data jpa
- spring security
- hibernate
- postgresql 15
- flyway
- thymeleaf + bootstrap
- caffeine cache
- junit 5 + mockito
- docker
- swagger (openapi 3)

## quick start

### prerequisites

- java 17+
- maven 3.9+
- docker desktop

### 1. clone repository

    git clone https://github.com/mtvvrm11/vels-onboarding-platform.git
    cd vels-onboarding-platform

### 2. start database

    docker-compose up -d postgres

### 3. build and run

    mvn clean package
    mvn spring-boot:run

### 4. open in browser

    http://localhost:8082

swagger ui:

    http://localhost:8082/swagger-ui.html

## project structure

    vels-onboarding-platform/
    src/main/java/org/example/
        VelsOnboardingApplication.java
        config/
            SecurityConfig.java
            SwaggerConfig.java
            CacheConfig.java
        controller/
            HomeController.java
            DashboardController.java
            CourseViewController.java
            ModuleViewController.java
            LessonViewController.java
            AdminController.java
            rest/
                CourseController.java
                ProgressController.java
                AuthController.java
        entity/
            User.java
            Role.java
            Course.java
            Module.java
            Lesson.java
            Progress.java
            Test.java
            Question.java
            Answer.java
            Result.java
        repository/
            ...
        service/
            CourseService.java
            ProgressService.java
            TestService.java
            UserService.java
            EmailService.java
        exception/
            GlobalExceptionHandler.java
    src/main/resources/
        application.yml
        templates/
        static/
        db/migration/
    pom.xml
    docker-compose.yml
    README.md
    LICENSE

## api endpoints

| method | endpoint | description |
|--------|----------|-------------|
| get | /api/courses | get all courses |
| get | /api/courses/{id} | get course with modules |
| post | /api/courses | create course |
| delete | /api/courses/{id} | delete course |
| get | /api/modules/{id} | get module with lessons |
| get | /api/lessons/module/{id} | get lessons by module |
| post | /api/progress/start | start course |
| put | /api/progress/update | update progress |
| get | /api/progress/user/{id} | get user progress |
| post | /api/auth/register | register user |

## database

11 tables:

- roles
- users
- courses
- modules
- lessons
- progress
- tests
- questions
- answers
- results
- flyway_schema_history

## license

mit license. see license file for details.

## author

irina matveeva

- github: https://github.com/mtvvrm11
- linkedin: https://linkedin.com/in/mtvvrm