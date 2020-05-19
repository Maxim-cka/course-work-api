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
@RequestMapping("/api/schedule")
@CrossOrigin(value = WEB_SITE_URL)
public class Schedule {
    private NamedParameterJdbcTemplate template;

    public Schedule(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @GetMapping("all")
    public List<Map<String, Object>> findAllSchedule() {
        return template.query("SELECT start_date, end_date, room_number, title FROM schedule_subject_map " +
                "LEFT JOIN room r on schedule_subject_map.room_id = r.id " +
                "LEFT JOIN schedule s on schedule_subject_map.schedule_id = s.id " +
                "LEFT JOIN subject s2 on schedule_subject_map.subject_id = s2.id", new ObjectRowMapper());
    }
}