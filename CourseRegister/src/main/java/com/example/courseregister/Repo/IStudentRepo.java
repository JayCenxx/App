package com.example.courseregister.Repo;
import com.example.courseregister.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IStudentRepo extends JpaRepository<Student,Integer> {
}
