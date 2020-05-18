package com.pc4p.subject_course_map;

import com.pc4p.course.Course;
import com.pc4p.subject.Subject;

import javax.persistence.*;

@Entity
@Table(name = "subject_course_map")
public class Subject_course_map {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Subject_course_map(int id, Course course, Subject subject) {
        this.id = id;
        this.course = course;
        this.subject = subject;
    }

    public Subject_course_map() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}