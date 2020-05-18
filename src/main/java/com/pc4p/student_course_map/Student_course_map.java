package com.pc4p.student_course_map;

import com.pc4p.student.Student;
import com.pc4p.course.Course;
import com.pc4p.teacher.Teacher;

import javax.persistence.*;

@Entity
@Table(name = "student_course_map")
public class Student_course_map {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    public Student_course_map(int id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }

    public Student_course_map() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
