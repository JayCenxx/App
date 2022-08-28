package com.example.courseregister.Test;

import com.example.courseregister.Entities.Course;
import com.example.courseregister.Entities.Student;
import com.example.courseregister.Entities.Teacher;
import com.example.courseregister.Repo.ICourse;
import com.example.courseregister.Repo.IStudentRepo;

import com.example.courseregister.Repo.ITeacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class test1 {
    @Autowired
    IStudentRepo SR;

    @Autowired
    ITeacher IT;

    @Autowired
    ICourse IC;

    @Test
    public void save(){
        Course math = new Course("Math");
        Student student =new Student("Jan", "Cen");
//        math.setStudent(student);
        IC.save(math);
    }

    @Test
    public void fetchACourseInfo(){
        Course course = IC.findById(10).get();
        System.out.println(course);
    }

    @Test
    public void RegisterATeacher(){
        Course course = IC.findById(10).get();
        Teacher teacher = new Teacher("Albert", "Einstein", "Einstein@gmail.com");
        course.setTeacher(teacher);
        IC.save(course);

    }

    @Test
    public void getCourse(){
        List<Course> all = IC.findAll();
       all.forEach(p-> System.out.println(p));

    }

}
