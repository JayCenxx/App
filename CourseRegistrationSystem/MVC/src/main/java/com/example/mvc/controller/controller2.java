package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/controller2")
@SessionAttributes("three")
public class controller2 {


    @GetMapping("")
    public String home(@SessionAttribute("three")int num,Model m){
        m.addAttribute("three",num);
return "test3";
    }


    @GetMapping("/stu")
    public String setSession() {
        return "home";
    }

}
