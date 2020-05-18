package com.pc4p.course;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(value = "http://localhost:63343")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> findAllCourse() {
        return courseService.findAllCourses();
    }

    @GetMapping("{id}")
    public Course findById(@PathVariable int id) {
        return courseService.findById(id);
    }
}
