package com.example.courseregister.Entities;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="teacher")

public class Teacher implements Serializable {

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


//        @OneToMany(mappedBy = "teacher",
//                fetch=FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//        private List<Course> course;




        public Teacher(String firstName, String lastName, String email) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
        }



}
