package com.example.restconsume.Feign;
import com.example.restconsume.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiController")
@Primary
public class apiController implements apiService{

    @Autowired
    private apiService proxy;

    @Override
    public List<Student> getAll() {
        List<Student> all = proxy.getAll();
        return all;
    }

    @GetMapping("/{id}")
    @Override
    public Student getById(@PathVariable int id) {
        Student student = proxy.getById(id);
        return student;
    }


}
