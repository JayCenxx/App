package com.example.restconsume.Controller;

import com.example.restconsume.Entity.Stu.Course;
import com.example.restconsume.Entity.Stu.Student;
import com.example.restconsume.Feign.apiController;
import com.example.restconsume.Service.shoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller

@RequestMapping("/course")
@Scope("session")
//need to put "student" here inorder to transfer it over from studentController
@SessionAttributes({"shoppingCart, courses, student"})
public class courseController {
    @Autowired
    apiController apiC;

    @Autowired
    shoppingCart sc;



    //needed all the courses
    @GetMapping("/searCourse")
    public String searCourse(Model m, @SessionAttribute("student") Student s) {
        List<Course> course = apiC.getCourse();
        m.addAttribute("courses",course);
        m.addAttribute("student",s);
        System.out.println(s.getId());

        return "searCourse";
    }


    @GetMapping("/getshopping")
    public String getshoppingCart(Model m){
        m.getAttribute("shoppingCart");
        return "shoppingCart";
    }


    @GetMapping("/setshopping/{studentId}/{courseId}")
    public String setshoppingCart(@PathVariable int studentId, @PathVariable int courseId,Model m){
//        Map<Integer,List<Integer>>sp= (Map<Integer, List<Integer>>) m.getAttribute("shoppingCart");
        Map<Integer, List<Integer>> shoppingCart = sc.getShoppingCart();
        sc.setShoppingCart(studentId,courseId);
        m.addAttribute("shoppingCart",shoppingCart);

        return "shoppingCart";
    }


}
