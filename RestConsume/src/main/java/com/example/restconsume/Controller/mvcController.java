package com.example.restconsume.Controller;
import com.example.restconsume.Feign.apiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mvcController  {
    //test the rest endpoint, so Convert the JSON to POJO, convert POJO to model attribute

    @Autowired
    apiController apiC;

    @GetMapping("/student")
    public String getAll() {
        System.out.println(apiC.getAll());
        return "student";
    }





}
