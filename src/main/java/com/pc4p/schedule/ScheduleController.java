package com.pc4p.schedule;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Schedule> findAllSchedule() {
        return scheduleService.findAllSchedule();
    }

    @GetMapping("{id}")
    public Schedule findById(@PathVariable int id) {
        return scheduleService.findById(id);
    }
}
