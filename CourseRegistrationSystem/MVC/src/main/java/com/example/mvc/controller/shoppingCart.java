package com.example.mvc.controller;
import com.example.mvc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"three"})
public class shoppingCart {

@Autowired
service se;

@GetMapping("/")
    public String getSession(Model m){
   m.addAttribute("three",300);
    return "form";
                    }

}
