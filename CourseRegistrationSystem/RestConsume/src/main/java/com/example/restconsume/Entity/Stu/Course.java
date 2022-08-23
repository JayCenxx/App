package com.example.restconsume.Entity.Stu;


import com.example.restconsume.Entity.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor


public class Course implements Serializable {


   private int id;


    private String courseName;

    private Teacher teacher;

    public Course(String courseName) {
        this.courseName = courseName;
    }






    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    //add a teacher to a course
//    public void setTeacher(Teacher t){
//        //if teacher arg is not null, then add it
//        if(t!=null)
//          teacher=t;
//    }

//    //add a student to a course
//    public void setStudent(Student s){
//        if(student==null)
//            student=new ArrayList<>();
//
//        student.add(s);
//    }



}
