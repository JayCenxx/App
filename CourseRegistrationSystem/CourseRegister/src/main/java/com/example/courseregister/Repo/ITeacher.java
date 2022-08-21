package com.example.courseregister.Repo;

import com.example.courseregister.Entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacher extends JpaRepository<Teacher,Integer> {
}
