package com.example.restconsume.Feign;
import com.example.restconsume.Entity.Stu.Course;
import com.example.restconsume.Entity.Stu.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiController")
@Primary
public class apiController implements apiService{

    @Autowired
    private apiService proxy;

    @Override
    public  List<Student> getAll() {

        return proxy.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public Student getStudentById(@PathVariable int id) {
        Student student = proxy.getStudentById(id);
        return student;
    }

    @Override
    public List<Course> getCourse() {
        return proxy.getCourse();
    }

    @Override
    public void registerCourses(@PathVariable("id") int studentId, @RequestBody List<Course> cList) {
        proxy.registerCourses(studentId,cList);

    }

    @Override
    public void dropACourse(@PathVariable("id") int studentId,@PathVariable("cid")int courseId){
proxy.dropACourse(studentId,courseId);
    }


}
