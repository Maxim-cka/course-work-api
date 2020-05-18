package com.pc4p.student_course_map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student_course_map")
public class Student_course_mapController {
    private final Student_course_mapService student_course_mapService;

    public Student_course_mapController(Student_course_mapService student_course_mapService) {
        this.student_course_mapService = student_course_mapService;
    }

    @GetMapping
    public List<Student_course_map> findAllStudent_course_map() {
        return student_course_mapService.findAllStudent_course_map();
    }

    @GetMapping("{id}")
    public Student_course_map findById(@PathVariable int id) {
        return student_course_mapService.findById(id);
    }
}
