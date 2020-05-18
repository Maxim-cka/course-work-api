package com.pc4p.schedule_subject_map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Schedule_subject_mapRepository extends JpaRepository<Schedule_subject_map, Integer> {
    @Query(value = "SELECT * FROM schedule_subject_map", nativeQuery = true)
    List<Schedule_subject_map> findAll();
}
