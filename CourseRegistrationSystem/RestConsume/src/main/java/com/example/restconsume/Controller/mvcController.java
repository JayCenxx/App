package com.example.restconsume.Controller;

import com.example.restconsume.Entity.Stu.Course;
import com.example.restconsume.Entity.Stu.Student;
import com.example.restconsume.Feign.apiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class mvcController  {
    @Autowired
    apiController apiC;

    @GetMapping("/student")
    public String getAll(Model m) {
        List<Student> all = apiC.getAll();
        m.addAttribute("student",all);
//        all.forEach(a->a.getCourseList().forEach(b-> System.out.println(b) )  );

        return "student";
    }

    @GetMapping("/getCourse/{studentId}")
    public String getCourse(Model m, @PathVariable int studentId) {
        List<Course> course = apiC.getCourse();
        m.addAttribute("courses",course);
        System.out.println(course);
        return "course";
    }

}
