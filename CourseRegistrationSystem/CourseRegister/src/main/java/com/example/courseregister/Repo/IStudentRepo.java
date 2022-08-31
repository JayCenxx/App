package com.example.courseregister.Repo;
import com.example.courseregister.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IStudentRepo extends JpaRepository<Student,Integer> {


}
