package com.pc4p.schedule_subject_map;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Schedule_subject_mapService {

    private final Schedule_subject_mapRepository schedule_subject_mapRepository;

    public Schedule_subject_mapService(Schedule_subject_mapRepository schedule_subject_mapRepository) {
        this.schedule_subject_mapRepository = schedule_subject_mapRepository;
    }

    public List<Schedule_subject_map> findAllSchedule_subject_map() {
        return schedule_subject_mapRepository.findAll();
    }

    public Schedule_subject_map findById(int id) {
        return schedule_subject_mapRepository.findById(id).get();
    }
}
