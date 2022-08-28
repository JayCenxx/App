package com.example.courseregister.Service;
import com.example.courseregister.Entities.Course;
import com.example.courseregister.Entities.Student;
import com.example.courseregister.Repo.ICourse;
import com.example.courseregister.Repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class stuService {
    @Autowired
    private IStudentRepo IS;

    @Autowired
    private ICourse IC;

    public List<Student> findStudentAll(){
        List<Student> all = IS.findAll();
        return all;
    }


    public Student findStudentById(@PathVariable int id){
        Student student = IS.findById(id).get();
        return student;
    }

    public void registerCourses(int studentId,List<Course> c){
        Student student = findStudentById(studentId);


        for(Course i:c) {
            student.setCourseList(i);
            System.out.println(i);
        }
          IS.save(student);


    }
}
