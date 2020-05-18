package com.pc4p.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM student", nativeQuery = true)
    List<Student> findAll();

    @Query(value = "SELECT * FROM student WHERE age <= 5 AND sex = 'чоловік'", nativeQuery = true)
    List<Student> findAllByAgeAndSex();

    @Query(value = "SELECT * FROM student WHERE age <= 5 OR sex = 'чоловік'", nativeQuery = true)
    List<Student> findAllByAgeOrSex();

    @Query(value = "SELECT DISTINCT first_name FROM student", nativeQuery = true)
    List<Student> findNames();

    @Query(value = "SELECT student_id as id, first_name, last_name, course.title FROM course \n" +
            "    RIGHT JOIN student_course_map scm on course.id = scm.course_id \n" +
            "    RIGHT JOIN student s on scm.student_id = s.id", nativeQuery = true)
    List<Student> findAllStudentsWithCourse();

    @Query(value = "SELECT student_id as id, first_name, last_name, course.title FROM course\n" +
            "    INNER JOIN student_course_map scm on course.id = scm.course_id\n" +
            "    INNER JOIN student s on scm.student_id = s.id", nativeQuery = true)
    List<Student> findStudentsWithCourse();
}
