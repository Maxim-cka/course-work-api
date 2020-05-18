package com.pc4p.course;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public Course findById(int id) {
        return courseRepository.findById(id).get();
    }
}
