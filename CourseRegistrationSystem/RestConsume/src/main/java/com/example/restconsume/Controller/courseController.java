package com.example.restconsume.Controller;

import com.example.restconsume.Entity.Stu.Course;
import com.example.restconsume.Entity.Stu.Student;
import com.example.restconsume.Feign.apiController;
import com.example.restconsume.Service.courService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller

@RequestMapping("/course")
@SessionAttributes({"shoppingCart","courses", "student"})
public class courseController {
    @Autowired
    private apiController apiC;

    @Autowired
    private courService cs;


    //needed all the courses
    //and i  use @SessionA.. parameter to fetch the student object, but u still need to add it to
    //model-attribute for this method to work
    @GetMapping("/searCourse")
    public String searCourse(Model m, @SessionAttribute("student") Student s) {
        //get All courses
        List<Course> course = apiC.getCourse();
        m.addAttribute("courses", course);
        m.addAttribute("student", s);
        System.out.println(course);
        return "searCourse";
    }


    @GetMapping("/shopping")
    public String getshoppingCart(@SessionAttribute("student") Student s, Model m) {
        Map<Integer, Course> sp = cs.getCourseFromCart(s.getId());
        m.addAttribute("shoppingCart", sp);
        return "shoppingCart";
    }


    //add to shopping cart
    @GetMapping("/shopping/{studentId}/{courseId}")
    public String addtoshoppingCart(@PathVariable int studentId, @PathVariable("courseId") int courseIndex,
                                  Model m, @SessionAttribute("courses") List<Course> c) {
        //goal: access the map by its key, and send me back a list

        Map<Integer, Course> shoppingCart = cs.setshoppingCart(studentId, courseIndex, c);

        return "redirect:/course/searCourse";
    }

    //delete one row from cart
    @DeleteMapping("/shopping")
    public String deleteFromCart(@RequestParam int key, @SessionAttribute("student") Student s, Model m) {
        m.addAttribute("student", s);
        cs.deleteCourseFromCart(key, s.getId());
        return "redirect:/course/shopping";
    }


}

