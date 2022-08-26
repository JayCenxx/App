package com.example.mvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@SessionAttributes()
public class shoppingCart {

@Autowired
service se;




@GetMapping("/")
    public String getSession(@RequestParam(required=false) String fname,@RequestParam(required=false) String lname,Model m){
    HashMap<String, String> map = new HashMap<>();
    map.put("1","one");
    map.put("2","two");
    map.put("3","three");
    m.addAttribute("map",map);
    m.addAttribute("one",'1');
    return "form";
}



}
