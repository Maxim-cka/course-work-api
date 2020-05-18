package com.pc4p.subject_course_map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subject_course_map")
public class Subject_course_mapController {
    private final Subject_course_mapService subject_course_mapService;

    public Subject_course_mapController(Subject_course_mapService subject_course_mapService) {
        this.subject_course_mapService = subject_course_mapService;
    }

    @GetMapping
    public List<Subject_course_map> findAllSubject_course_map() {
        return subject_course_mapService.findAllSubject_course_map();
    }

    @GetMapping("{id}")
    public Subject_course_map findById(@PathVariable int id) {
        return subject_course_mapService.findById(id);
    }
}

