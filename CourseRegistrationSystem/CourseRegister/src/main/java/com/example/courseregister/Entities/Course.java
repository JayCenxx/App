package com.example.courseregister.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="course")



@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="course_id" ,nullable = false)
   private int id;

    @Column(name="course_name",nullable = false)
    private String courseName;


    public Course(String courseName) {
        this.courseName = courseName;
    }


//    @ManyToMany(mappedBy = "courseList",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private List<Student> student;

    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="teacher_teacher_id")
    private Teacher teacher;



    //add a teacher to a course
    public void setTeacher(Teacher t){
        //if teacher arg is not null, then add it
        if(t!=null)
          teacher=t;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
