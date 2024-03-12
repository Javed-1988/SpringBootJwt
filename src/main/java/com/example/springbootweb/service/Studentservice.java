package com.example.springbootweb.service;

import com.example.springbootweb.exception.IdNotFoundException;
import com.example.springbootweb.model.Student;

import java.util.List;

public interface Studentservice {

    Student save(Student student);
     List<Student> getStudent();
     Student getStudentById(int id) throws IdNotFoundException;
     List<Student> getStudentByName(String name);
     String delStudentById(int id);
     Student updateStudentById(Student student);

}
