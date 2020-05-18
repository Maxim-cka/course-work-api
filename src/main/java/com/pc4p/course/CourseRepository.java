package com.pc4p.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query(value = "SELECT * FROM course", nativeQuery = true)
    List<Course> findAll();

    @Query(value = "SELECT * FROM course WHERE price BETWEEN 5000 AND 10000", nativeQuery = true)
    List<Course> findMediumPriceCourse();

    @Query(value = "SELECT MAX(price) FROM course", nativeQuery = true)
    List<Double> findMaxPrice();

    @Query(value = "SELECT AVG(price) FROM course", nativeQuery = true)
    List<Double> findAVGPrice();

    @Query(value = "SELECT COUNT(price) FROM course", nativeQuery = true)
    List<Integer> findCountOfCourses();

    @Query(value = "SELECT * FROM course WHERE price >= (SELECT AVG(price) FROM course)", nativeQuery = true)
    List<Course> findCoursesMoreAVG();

    @Query(value = "SELECT * FROM course WHERE price = (SELECT MAX(price) FROM course)", nativeQuery = true)
    List<Course> findCoursesMaxPrice();
}
