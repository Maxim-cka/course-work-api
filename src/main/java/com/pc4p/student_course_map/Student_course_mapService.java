package com.pc4p.student_course_map;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student_course_mapService {

    private final Student_course_mapRepository student_course_mapRepository;

    public Student_course_mapService(Student_course_mapRepository student_course_mapRepository) {
        this.student_course_mapRepository = student_course_mapRepository;
    }

    public List<Student_course_map> findAllStudent_course_map() {
        return student_course_mapRepository.findAll();
    }

    public Student_course_map findById(int id) {
        return student_course_mapRepository.findById(id).get();
    }
}
