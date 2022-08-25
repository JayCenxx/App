package com.example.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("List")
@Scope("session")
public class shoppingCart {



@ModelAttribute("List")
public List<Student> test(){
        return new ArrayList<>();
    }

    @GetMapping("/")
public String setSession(Model m){


    return "home";
}

@GetMapping("/student")
    public String getSession(@RequestParam String fname,@RequestParam String lname,Model m){
    List<Student> studentList= (List<Student>) m.getAttribute("List");
    Student student = new Student(fname, lname);
    studentList.add(student);
    m.addAttribute("List",studentList);
        return "form";
}


}
