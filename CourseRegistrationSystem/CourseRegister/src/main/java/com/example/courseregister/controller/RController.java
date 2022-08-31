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
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class RController {
    @Autowired
    private stuService IS;

    @Autowired
    private courService IC;

    @Autowired
    private teaService IT;

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

//a student add one or multiple courses
    @PostMapping("/student/{id}")
    public void RegisterCourses(@PathVariable("id") int studentId,@RequestBody List<Course> cList){
     IS.registerCourses(studentId,cList);
    }

    @DeleteMapping("/student/{id}/{cid}")
    public void dropACourse(@PathVariable("id") int studentId,@PathVariable("cid")int courseId){
    IS.dropACourse(studentId,courseId);
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

