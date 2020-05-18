package com.pc4p.student_course_map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Student_course_mapRepository extends JpaRepository<Student_course_map, Integer> {
    @Query(value = "SELECT * FROM student_course_map", nativeQuery = true)
    List<Student_course_map> findAll();
}
