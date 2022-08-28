package com.example.mvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("one")
public class shoppingCart {

@Autowired
service se;

@GetMapping("/")
    public String getSession(Model m){
    m.addAttribute("one",1000);
    return "forward:/student";
                    }

@GetMapping("/student")
    public String setSession() {
return "forward:/student2";
}

    @GetMapping("/student2")
    public String student2() {
        return "home";
    }

}
