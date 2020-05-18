package com.pc4p.schedule_subject_map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/schedule_subject_map")
public class Schedule_subject_mapController {
    private final Schedule_subject_mapService schedule_subject_mapService;

    public Schedule_subject_mapController(Schedule_subject_mapService schedule_subject_mapService) {
        this.schedule_subject_mapService = schedule_subject_mapService;
    }

    @GetMapping
    public List<Schedule_subject_map> findAllSchedule_subject_map() {
        return schedule_subject_mapService.findAllSchedule_subject_map();
    }

    @GetMapping("{id}")
    public Schedule_subject_map findById(@PathVariable int id) {
        return schedule_subject_mapService.findById(id);
    }
}
