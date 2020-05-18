package com.pc4p.schedule_subject_map;

import com.pc4p.subject.Subject;
import com.pc4p.schedule.Schedule;
import com.pc4p.room.Room;

import javax.persistence.*;

@Entity
@Table(name = "schedule_subject_map")
public class Schedule_subject_map {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    public Schedule_subject_map(int id, Subject subject, Schedule schedule, Room room) {
        this.id = id;
        this.subject = subject;
        this.schedule = schedule;
        this.room = room;
    }

    public Schedule_subject_map() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}