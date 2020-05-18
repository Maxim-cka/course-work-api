package com.pc4p.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query(value = "SELECT * FROM subject", nativeQuery = true)
    List<Subject> findAll();

    @Query(value = "SELECT * FROM subject WHERE title IN ('Англійська', 'Українська', 'Німецька')", nativeQuery = true)
    List<Subject> findAllLanguages();

    @Query(value = "SELECT * FROM subject WHERE title LIKE '%Англ%'", nativeQuery = true)
    Optional<Subject> findByTitle();

    @Query(value = "SELECT subject.id, subject.title, last_name FROM subject\n" +
            "    INNER JOIN teacher t on subject.teacher_id = t.id", nativeQuery = true)
    List<Subject> findSubjectsWithTeacherNames();

    @Query(value = "SELECT subject.id, subject.title, last_name FROM subject\n" +
            "    LEFT JOIN teacher t on subject.teacher_id = t.id ORDER BY title", nativeQuery = true)
    List<Subject> findSubjectsAndTeachersOrder();

    @Query(value = "SELECT * FROM subject WHERE teacher_id IN (SELECT id FROM teacher WHERE salary < 10000)", nativeQuery = true)
    List<Subject> findSubjectsTeacherWithMiddleSalary();

    @Query(value = "SELECT subject.id, title, first_name, last_name FROM subject\n" +
            "    INNER JOIN teacher t on subject.teacher_id = t.id\n" +
            "WHERE first_name LIKE \"%ко\"", nativeQuery = true)
    List<Subject> findSubjectByTeacherName();

    @Query(value = "SELECT COUNT(*) FROM subject WHERE teacher_id = 1", nativeQuery = true)
    List<Subject> findCountSubjectsByTeacher();
}
