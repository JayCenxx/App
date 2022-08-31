package com.example.restconsume.Service;

import com.example.restconsume.Entity.Stu.Course;
import com.example.restconsume.Entity.Stu.Student;
import com.example.restconsume.Feign.apiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class stuService {
    @Autowired
    apiController apiC;


    public List<Student> getStudentAll() {
        List<Student> studentList = apiC.getAll();
    return  studentList;
    }

    public Student getStudentByID(int studentId){

        Student studentById = apiC.getStudentById(studentId);
        return  studentById;
    }


    public void registerACourse(Student s,
                                  Map<Integer, Course> map ){

        List<Course> courses = new ArrayList<>(map.values());
        apiC.registerCourses(s.getId(),courses);


    }

    public void deleteACourse(int studentId,int courseId ){
    apiC.dropACourse(studentId,courseId);
    }

}
