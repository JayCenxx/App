package com.example.courseregister.Repo;

import com.example.courseregister.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourse extends JpaRepository<Course,Integer> {
}
