package com.example.courseregister.Service;
import com.example.courseregister.Repo.ITeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collections;
import java.util.List;

@Service
public class teaService {

    @Autowired
    ITeacher IT;

    @GetMapping("/teacher")
    public List<Object> getTeacherAll(){
        List<Object> all = Collections.singletonList(IT.findAll());
        return all;
    }
}
