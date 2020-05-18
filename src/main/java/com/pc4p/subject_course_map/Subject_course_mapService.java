package com.pc4p.subject_course_map;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Subject_course_mapService {

    private final Subject_course_mapRepository subject_course_mapRepository;

    public Subject_course_mapService(Subject_course_mapRepository subject_course_mapRepository) {
        this.subject_course_mapRepository = subject_course_mapRepository;
    }

    public List<Subject_course_map> findAllSubject_course_map() {
        return subject_course_mapRepository.findAll();
    }

    public Subject_course_map findById(int id) {
        return subject_course_mapRepository.findById(id).get();
    }
}
