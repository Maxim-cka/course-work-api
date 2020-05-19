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
@RequestMapping("/api/room")
@CrossOrigin(value = WEB_SITE_URL)
public class Room {
    private NamedParameterJdbcTemplate template;

    public Room(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @GetMapping("all")
    public List<Map<String, Object>> findAllRooms() {
        return template.query("SELECT * FROM room", new ObjectRowMapper());
    }
}
