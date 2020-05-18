package com.pc4p.schedule;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository roomRepository) {
        this.scheduleRepository = roomRepository;
    }

    public List<Schedule> findAllSchedule() {
        return scheduleRepository.findAll();
    }

    public Schedule findById(int id) {
        return scheduleRepository.findById(id).get();
    }
}
