package com.example.courseregister.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor

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
        private List<Course> course;



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


        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public List<Course> getCourse() {
                return course;
        }

        public void setCourse(List<Course> course) {
                this.course = course;
        }
}
