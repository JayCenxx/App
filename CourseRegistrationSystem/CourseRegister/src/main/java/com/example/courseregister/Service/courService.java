package com.example.courseregister.Service;
import com.example.courseregister.Entities.Course;
import com.example.courseregister.Repo.ICourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class courService {

    @Autowired
    ICourse IC;


    public List<Course> getCourseAll(){
        List<Course> course = IC.findAll();
        return course;
    }



}
