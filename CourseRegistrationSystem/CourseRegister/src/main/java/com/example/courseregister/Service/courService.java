package com.example.courseregister.Service;
import com.example.courseregister.Entities.Course;
import com.example.courseregister.Repo.ICourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class courService {

    @Autowired
    ICourse IC;


    public List<Course> getCourseAll(){
        List<Course> course = IC.findAll();
        return course;
    }

public Course findCourseById(int courseId){
    Course course = IC.findById(courseId).get();
   return course;
}

}
