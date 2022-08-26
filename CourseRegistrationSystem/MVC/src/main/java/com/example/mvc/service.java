package com.example.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class service {



    public void setSC(List<Student> studentList,String fname, String lname){
        Student student = new Student(fname, lname);
        studentList.add(student);

    }

    @Bean
    @SessionScope
    public List<Student> getStudentList() {
        List<Student> studentList=new ArrayList<>();
        return studentList;
    }
}
