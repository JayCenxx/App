package com.example.restconsume.Controller;

import com.example.restconsume.Entity.Stu.Course;
import com.example.restconsume.Entity.Stu.Student;
import com.example.restconsume.Feign.apiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/course")
public class courseController {
    @Autowired
    apiController apiC;


    //needed all the courses
    @GetMapping("/searCourse")
    public String searCourse(Model m, @SessionAttribute("student") Student s) {
        List<Course> course = apiC.getCourse();
        System.out.println(s.getId());
        m.addAttribute("courses",course);
        System.out.println(course);
        return "searCourse";
    }


}
