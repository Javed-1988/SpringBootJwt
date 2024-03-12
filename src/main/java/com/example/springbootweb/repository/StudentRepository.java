package com.example.springbootweb.repository;

import com.example.springbootweb.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
     List<Student> findByName(String name);

}
