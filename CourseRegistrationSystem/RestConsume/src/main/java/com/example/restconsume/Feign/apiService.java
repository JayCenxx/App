package com.example.restconsume.Feign;
import com.example.restconsume.Entity.Stu.Course;
import com.example.restconsume.Entity.Stu.Student;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="service", url="http://localhost:80/")
public interface apiService {

@GetMapping(value = "/student")
@Headers(value = "Content-Type: application/json")
 List<Student> getAll();

@GetMapping(value ="/student/{id}")
public Student getStudentById(@PathVariable int id);

    @GetMapping(value = "/course")
    @Headers(value = "Content-Type: application/json")
     List<Course> getCourse();

    @PostMapping("/student/{id}")
    @ResponseBody
    public void registerCourses(@PathVariable("id") int studentId,@RequestBody List<Course> cList);

}
