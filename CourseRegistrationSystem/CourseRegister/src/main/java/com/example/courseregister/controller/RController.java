package com.example.courseregister.controller;

import com.example.courseregister.Entities.Course;
import com.example.courseregister.Entities.Student;
import com.example.courseregister.Repo.ICourse;
import com.example.courseregister.Repo.IStudentRepo;
import com.example.courseregister.Repo.ITeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class RController {
    @Autowired
    IStudentRepo IS;

    @Autowired
    ICourse IC;

    @Autowired
    ITeacher IT;

    @GetMapping("/student")
    public List<Student> getAll(){
        List<Student> all = IS.findAll();
        return all;
    }

    @GetMapping("/student/{id}")
    public Student getAll(@PathVariable int id){
        Student student = IS.findById(id).get();
        System.out.println(student);
    return student;
    }

    @GetMapping("/course")
    public List<Course> getCourseAll(){
        List<Course> course = IC.findAll();
        return course;
    }

    @GetMapping("/teacher")
    public List<Object> getTeacherAll(){
        List<Object> all = Collections.singletonList(IT.findAll());
        System.out.println(all);
        return all;
    }

    }

