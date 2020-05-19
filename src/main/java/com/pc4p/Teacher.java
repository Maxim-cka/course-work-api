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
@RequestMapping("/api/teacher")
@CrossOrigin(value = WEB_SITE_URL)
public class Teacher {
    private NamedParameterJdbcTemplate template;

    public Teacher(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @GetMapping("all")
    public List<Map<String, Object>> findAllTeachers() {
        return template.query("SELECT * FROM teacher", new ObjectRowMapper());
    }

    @GetMapping("group-with-subjects")
    public List<Map<String, Object>> findAllTeachersWithCountOfSubjects() {
        return template.query("SELECT teacher_id, first_name, last_name, COUNT(*) as count_of_subjects FROM subject\n" +
                "    LEFT JOIN teacher t2 on subject.teacher_id = t2.id\n" +
                "GROUP BY teacher_id", new ObjectRowMapper());
    }
}

