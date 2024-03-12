package com.example.springbootweb.service;

import com.example.springbootweb.exception.IdNotFoundException;
import com.example.springbootweb.model.Student;
import com.example.springbootweb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements Studentservice {

    private final StudentRepository repository;
    @Autowired
    public StudentServiceImpl(StudentRepository repository)
    {
        this.repository=repository;
    }

    @Override
    public Student save(Student student)
    {
       return repository.save(student);
    }
    @Override
    public List<Student> getStudent()
    {
        return repository.findAll();
    }
    @Override
    public Student getStudentById(int id) throws IdNotFoundException
    {
        return repository.findById(id).orElseThrow(()->new IdNotFoundException("Id not found with this id:"+id));
    }
    @Override
    public List<Student> getStudentByName(String name)
    {
         List<Student> list= repository.findByName(name);
         if(!list.isEmpty())
         {
             return list;
         }
         else {
              throw new IdNotFoundException();
         }

    }
    @Override
    public String delStudentById(int id)
    {
        Student student=repository.findById(id).orElseThrow(()->new IdNotFoundException("Id not found with this id:"+id));
        if (student!=null)
        {
            repository.deleteById(id);
        }
       return "Deleted";
    }
    @Override
    public Student updateStudentById(Student student)
    {
        Student std=repository.findById(student.getId()).orElseThrow(()->new IdNotFoundException("Id not found with this id:"+student.getId()));

        std.setId(student.getId());
        std.setName(student.getName());
        std.setEmail(student.getEmail());
        std.setAge(student.getAge());
        std.setAddress(student.getAddress());
        std.setContact_no(student.getContact_no());

        System.out.println("data----->"+std.toString());
        return repository.save(std);

    }
}
