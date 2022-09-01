package com.example.restconsume.Controller;

import com.example.restconsume.Entity.Stu.Course;
import com.example.restconsume.Entity.Stu.Student;
import com.example.restconsume.Feign.apiController;
import com.example.restconsume.Service.stuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
@SessionAttributes({"student","students","shoppingCart"})
public class studentController {
    @Autowired
    apiController apiC;

    @Autowired
    stuService SS;

    //get all the student records
    @GetMapping("")
    public String getStudentAll(Model m) {
        List<Student> all = SS.getStudentAll();
        m.addAttribute("students",all); //create the sessionAttribute: students
//        all.forEach(a->a.getCourseList().forEach(b-> System.out.println(b) )  );

        return "student";
    }

    //return the regCourse Page
    @GetMapping("regCourse")
    public String RegisterPage(){
        return "regCourse";
    }

    //needed a list of register courses related by student ID
    @GetMapping("/{studentId}")
    public String getStudentByID(RedirectAttributes m, @PathVariable int studentId) {
        Student student = SS.getStudentByID(studentId);
        m.addFlashAttribute("student",student); //create the sessionAttribute student

        //although a redirect do cause you to lose the model attribute,
        //but here you add it to sessionAtribute, so its available globally
        return "redirect:/student/regCourse";
    }

    @PostMapping("/registration")
    public String registerCourses(@SessionAttribute("student") Student s,
                                  @SessionAttribute("shoppingCart") Map<Integer, Course> map, Model m){
        //convert map to list
        SS.registerCourses(s,map);
        m.addAttribute("shoppingCart",map);

        return "redirect:/student/sucessful";
    }

    @DeleteMapping ("/registration/{courseId}")
    public String deleteACourse(@SessionAttribute("student") Student s,@PathVariable int courseId){
        System.out.println(courseId);
        SS.deleteACourse(s.getId(),courseId);
        return "redirect:/student/"+s.getId();
    }

    @GetMapping("sucessful")
    public String RegisterSuccessful(){
        return "successful";
    }



}

