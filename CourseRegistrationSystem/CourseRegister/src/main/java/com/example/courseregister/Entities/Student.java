package com.example.courseregister.Entities;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student {
@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
@Column(name="student_id")
private int id;

@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;


//@Column(name="email")
//private String email;

//
//@ManyToMany(fetch=FetchType.LAZY,  cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//@JoinTable(name="student_has_course",
//joinColumns = @JoinColumn(name="student_id"),
//inverseJoinColumns = @JoinColumn(name="course_id")
//)
//private List<Course> courseList;


    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



}
