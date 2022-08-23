package com.example.restconsume.Entity.Stu;

import lombok.*;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter

public class Student {

private int id;

private String firstName;

private String lastName;


 private List<Course> courseList;


    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
