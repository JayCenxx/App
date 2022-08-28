package com.example.restconsume.Entity.Stu;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter



public class Teacher implements Serializable {

        private int id;

        private String firstName;

        private String lastName;




        @Override
        public String toString() {
                return "Teacher{" +
                        "id=" + id +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        '}';
        }

        public Teacher(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;

        }



}
