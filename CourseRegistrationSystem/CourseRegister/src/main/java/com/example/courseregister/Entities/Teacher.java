package com.example.courseregister.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="teacher")


public class Teacher {

        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        @Column(name="teacher_id")
        private int id;

        @Column(name="first_name")
        private String firstName;

        @Column(name="last_name")
        private String lastName;

        @Column(name="email")
        private String email;


        @OneToMany(mappedBy = "teacher",
                fetch=FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
        private List<CourseOne> course;


        //exclude List<Course> course to prevent toString going into loop
        @Override
        public String toString() {
                return "Teacher{" +
                        "id=" + id +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", email='" + email + '\'' +
                        '}';
        }

        public Teacher(String firstName, String lastName, String email) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
        }



}
