package com.example.courseregister.controller;

import com.example.courseregister.Entities.Course;
import com.example.courseregister.Entities.Student;
import com.example.courseregister.Repo.ICourse;
import com.example.courseregister.Repo.IStudentRepo;
import com.example.courseregister.Repo.ITeacher;
import com.example.courseregister.Service.courService;
import com.example.courseregister.Service.stuService;
import com.example.courseregister.Service.teaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class RController {
    @Autowired
    stuService IS;

    @Autowired
    courService IC;

    @Autowired
    teaService IT;

    @GetMapping("/student")
    public List<Student> getAll(){
        List<Student> all = IS.findStudentAll();
        return all;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id){
        Student student = IS.findStudentById(id);
        System.out.println(student);
    return student;
    }

    @GetMapping("/course")
    public List<Course> getCourseAll(){
        List<Course> course = IC.getCourseAll();
        return course;
    }

    @GetMapping("/teacher")
    public List<Object> getTeacherAll(){
        List<Object> all = Collections.singletonList(IT.getTeacherAll());
        System.out.println(all);
        return all;
    }

    }

