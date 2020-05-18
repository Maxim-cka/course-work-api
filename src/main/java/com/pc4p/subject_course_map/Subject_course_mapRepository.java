package com.pc4p.subject_course_map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Subject_course_mapRepository extends JpaRepository<Subject_course_map, Integer> {
    @Query(value = "SELECT * FROM subject_course_map", nativeQuery = true)
    List<Subject_course_map> findAll();
}
