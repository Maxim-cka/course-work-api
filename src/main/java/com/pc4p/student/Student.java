package com.pc4p.student;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "parent_phone_number")
    private BigInteger parentPhoneNumber;

    @Column(name = "parent_first_name")
    private String parentFirstName;

    @Column(name = "parent_last_name")
    private String parentLastName;

    @Column(name = "sex")
    private String sex;

    public Student(int id, String firstName, String lastName, int age, BigInteger parentPhoneNumber, String parentFirstName, String parentLastName, String sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.parentPhoneNumber = parentPhoneNumber;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.sex = sex;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigInteger getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(BigInteger parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
