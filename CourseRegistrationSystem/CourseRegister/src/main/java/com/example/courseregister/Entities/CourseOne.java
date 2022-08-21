package com.example.courseregister.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="course")
public class CourseOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="course_id")
   private int id;

    @Column(name="course_name")
    private String courseName;

    public CourseOne(String courseName) {
        this.courseName = courseName;
    }

    @JsonBackReference
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
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
