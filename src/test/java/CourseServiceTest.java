import org.example.entity.Course;
import org.example.repository.CourseRepository;
import org.example.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/*
 * tests for course service.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("course service tests")
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private CourseService courseService;

    @BeforeEach
    void setUp() {
        courseService = new CourseService(courseRepository);
    }

    @Test
    @DisplayName("should find course with modules and lessons")
    void shouldFindCourseWithModules() {
        Course course = new Course();
        course.setId(1L);
        course.setTitle("welcome to vels");

        when(courseRepository.findByIdWithModulesAndLessons(1L))
                .thenReturn(Optional.of(course));

        Course result = courseService.findByIdWithModulesAndLessons(1L);

        assertNotNull(result);
        assertEquals("welcome to vels", result.getTitle());
    }
}