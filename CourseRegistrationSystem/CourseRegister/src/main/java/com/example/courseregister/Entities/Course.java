package com.example.courseregister.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="course_id")
   private int id;

    @Column(name="course_name")
    private String courseName;

    //establish a manytomany relationship,jointable using FK, and DI to student
    //SOLVE THE PROBLEM WITH FAILED T
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="student_has_course",
            joinColumns = @JoinColumn(name="course_idcourse"),
            inverseJoinColumns = @JoinColumn(name="student_idstudent"))
    private List<Student> student;

    public Course(String courseName) {
        this.courseName = courseName;
    }


    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="teacher_teacher_id")
    private Teacher teacher;



    //add a teacher to a course
    public void setTeacher(Teacher t){
        //if teacher arg is not null, then add it
        if(t!=null)
          teacher=t;
    }

    public void setStudent(Student s){
        if(student==null)
            student=new ArrayList<>();

        student.add(s);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", student=" + student +
                ", teacher=" + teacher +
                '}';
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
