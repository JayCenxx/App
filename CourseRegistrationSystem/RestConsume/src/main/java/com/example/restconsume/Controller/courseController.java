package com.example.restconsume.Controller;

import com.example.restconsume.Entity.Stu.Course;
import com.example.restconsume.Entity.Stu.Student;
import com.example.restconsume.Feign.apiController;
import com.example.restconsume.Service.Beans.shoppingCart;
import com.example.restconsume.Service.courService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Controller

@RequestMapping("/course")
@Scope("session")
//need to put "student" here inorder to transfer it over from studentController
@SessionAttributes({"shoppingCart","courses", "student"})
public class courseController {
    @Autowired
    private apiController apiC;

   @Autowired
   private courService cs;

   @Autowired
   private shoppingCart sc;


    //needed all the courses
    //and i  use @SessionA.. parameter to fetch the student object, but u still need to add it to
    //model-attribute for this method to work
    @GetMapping("/searCourse")
    public String searCourse(Model m, @SessionAttribute("student") Student s) {
        //get All courses
        List<Course> course = apiC.getCourse();
        m.addAttribute("courses",course);

        return "searCourse";
    }


    @GetMapping("/shopping")
    public String getshoppingCart(@SessionAttribute("shoppingCart") Map<Integer, Course> shoppingCart){
        return "shoppingCart";
    }


    @GetMapping("/shopping/{studentId}/{courseId}")
    public String setshoppingCart(@PathVariable int studentId, @PathVariable("courseId") int courseIndex,
                                  Model m, @SessionAttribute("courses") List<Course>c){
        //goal: access the map by its key, and send me back a list

        Map<Integer, Course> shoppingCart = cs.setshoppingCart(studentId, courseIndex,c);

        m.addAttribute("shoppingCart",shoppingCart);
        System.out.println(shoppingCart);
        return "shoppingCart";
    }
}
