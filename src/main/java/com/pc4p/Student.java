package com.pc4p;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.pc4p.Application.WEB_SITE_URL;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(value = WEB_SITE_URL)
public class Student {
    private NamedParameterJdbcTemplate template;

    public Student(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @GetMapping("all")
    public List<Map<String, Object>> findAllStudents() {
        return template.query("SELECT * FROM student", new ObjectRowMapper());
    }

    @GetMapping("by-sex-and-age")
    public List<Map<String, Object>> findAllByAgeAndSex() {
        return template.query("SELECT * FROM student WHERE age <= 5 AND sex = 'чоловік'", new ObjectRowMapper());
    }

    @GetMapping("names")
    public List<Map<String, Object>> findNames() {
        return template.query("SELECT DISTINCT first_name FROM student", new ObjectRowMapper());
    }

    @GetMapping("students-with-course")
    public List<Map<String, Object>> findStudentsWithCourse() {
        return template.query("SELECT student_id, first_name, last_name, course.title FROM course " +
                "    INNER JOIN student_course_map scm on course.id = scm.course_id " +
                "    INNER JOIN student s on scm.student_id = s.id", new ObjectRowMapper());
    }

    @GetMapping("all-students-with-course")
    public List<Map<String, Object>> findAllStudentsWithCourse() {
        return template.query("SELECT student_id, first_name, last_name, course.title FROM course " +
                "    RIGHT JOIN student_course_map scm on course.id = scm.course_id " +
                "    RIGHT JOIN student s on scm.student_id = s.id", new ObjectRowMapper());
    }

    @GetMapping("by-sex-or-age")
    public List<Map<String, Object>> findAllOrAgeAndSex() {
        return template.query("SELECT * FROM student WHERE age <= 5 OR sex = 'чоловік'", new ObjectRowMapper());
    }
}

