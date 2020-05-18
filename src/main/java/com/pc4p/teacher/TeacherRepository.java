package com.pc4p.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(value = "SELECT * FROM teacher", nativeQuery = true)
    List<Teacher> findAll();

    @Query(value = "SELECT teacher_id, first_name, last_name, COUNT(*) as count_of_subjects FROM subject\n" +
            "    LEFT JOIN teacher t2 on subject.teacher_id = t2.id\n" +
            "GROUP BY teacher_id", nativeQuery = true)
    List<Teacher> findAllTeachersWithCountOfSubjects();
}
