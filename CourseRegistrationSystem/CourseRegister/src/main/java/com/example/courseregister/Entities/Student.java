package com.example.courseregister.Entities;
import com.fasterxml.jackson.annotation.*;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="student")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Student implements Serializable {
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

    @JsonIdentityReference
@ManyToMany(fetch=FetchType.EAGER,  cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
@JoinTable(name="student_has_course",
        joinColumns = @JoinColumn(name="student_idstudent"),
        inverseJoinColumns = @JoinColumn(name="course_idcourse"))
private List<Course> courseList;


    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean setCourseList(Course c){
        //if the courseList is null, then initalize it
        if (courseList==null) {
            courseList = new LinkedList<>();
        }
     //check if the courseList is empty, add the elements
                if ( !CLcontainId(courseList,c)) {
                    courseList.add(c);
                }else{
                    System.out.println(c.getCourseName()+ " already exist");
                }

        return false;
                                        }

    public boolean CLcontainId(List<Course>a,Course b){
        for(Course i:a){
            //when ever courselist id == course id, that mean id exist
        if(i.getId()==b.getId()){
            return true;
        }
        }

        return false;
    }


}
