package com.example.restconsume.Controller;
import com.example.restconsume.Entity.Student;
import com.example.restconsume.Feign.apiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class mvcController  {
    //test the rest endpoint, so Convert the JSON to POJO, convert POJO to model attribute

    @Autowired
    apiController apiC;

    @GetMapping("/student")
    public String getAll(Model m) {
        List<Student> all = apiC.getAll();
        m.addAttribute("student",all);

        return "student";
    }





}
