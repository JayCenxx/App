package com.example.restconsume.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class Student {

private int id;

private String firstName;

private String lastName;




    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



}
