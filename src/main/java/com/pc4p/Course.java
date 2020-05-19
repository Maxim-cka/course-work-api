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
@RequestMapping("/api/course")
@CrossOrigin(value = WEB_SITE_URL)
public class Course {
    private NamedParameterJdbcTemplate template;

    public Course(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @GetMapping("all")
    public List<Map<String, Object>> findAllCourse() {
        return template.query("SELECT * FROM course", new ObjectRowMapper());
    }

    @GetMapping("medium")
    public List<Map<String, Object>> findMediumCourse() {
        return template.query("SELECT * FROM course WHERE price BETWEEN 5000 AND 10000", new ObjectRowMapper());
    }

    @GetMapping("max-price")
    public List<Map<String, Object>> findMaxPrice() {
        return template.query("SELECT MAX(price) as max_price FROM course", new ObjectRowMapper());
    }

    @GetMapping("avg-price")
    public List<Map<String, Object>> findAVGPrice() {
        return template.query("SELECT AVG(price) as avg_price FROM course", new ObjectRowMapper());
    }

    @GetMapping("count-course")
    public List<Map<String, Object>> findCOUNTCourse() {
        return template.query("SELECT COUNT(price) as count_course FROM course", new ObjectRowMapper());
    }

    @GetMapping("more-avg-price")
    public List<Map<String, Object>> findCoursesMoreAVG() {
        return template.query("SELECT * FROM course WHERE price >= (SELECT AVG(price) FROM course)", new ObjectRowMapper());
    }

    @GetMapping("course-with-max-price")
    public List<Map<String, Object>> findCoursesMaxPrice() {
        return template.query("SELECT * FROM course WHERE price = (SELECT MAX(price) FROM course)", new ObjectRowMapper());
    }
}
