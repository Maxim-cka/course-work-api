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
@RequestMapping("/api/subject")
@CrossOrigin(value = WEB_SITE_URL)
public class Subject {
    private NamedParameterJdbcTemplate template;

    public Subject(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @GetMapping("all")
    public List<Map<String, Object>> findAllSubject() {
        return template.query("SELECT * FROM subject", new ObjectRowMapper());
    }

    @GetMapping("all-languages")
    public List<Map<String, Object>> findAllLanguages() {
        return template.query("SELECT * FROM subject WHERE title IN ('Англійська', 'Українська', 'Німецька')", new ObjectRowMapper());
    }

    @GetMapping("all-with-teacher-name")
    public List<Map<String, Object>> findSubjectsWithTeacherNames() {
        return template.query("SELECT subject.id, subject.title, last_name FROM subject" +
                "    INNER JOIN teacher t on subject.teacher_id = t.id", new ObjectRowMapper());
    }

    @GetMapping("all-with-teacher-middle-salary")
    public List<Map<String, Object>> findSubjectsTeacherWithMiddleSalary() {
        return template.query("SELECT * FROM subject WHERE teacher_id IN (SELECT id FROM teacher WHERE salary < 10000)", new ObjectRowMapper());
    }

    @GetMapping("count-by-teacher")
    public List<Map<String, Object>> findCountSubjectsByTeacher() {
        return template.query("SELECT COUNT(*) as count_subjects FROM subject WHERE teacher_id = 1", new ObjectRowMapper());
    }

    @GetMapping("english")
    public List<Map<String, Object>> findEnglish() {
        return template.query("SELECT * FROM subject WHERE title LIKE '%Англ%'", new ObjectRowMapper());
    }

    @GetMapping("all-with-teacher-name-order")
    public List<Map<String, Object>> findSubjectsAndTeachersOrder() {
        return template.query("SELECT subject.id, subject.title, last_name FROM subject" +
                "           LEFT JOIN teacher t on subject.teacher_id = t.id ORDER BY title", new ObjectRowMapper());
    }

    @GetMapping("by-teacher-name")
    public List<Map<String, Object>> findSubjectByTeacherName() {
        return template.query("SELECT subject.id, title, first_name, last_name FROM subject" +
                "    INNER JOIN teacher t on subject.teacher_id = t.id " +
                "WHERE first_name LIKE \"%ко\"", new ObjectRowMapper());
    }
}
