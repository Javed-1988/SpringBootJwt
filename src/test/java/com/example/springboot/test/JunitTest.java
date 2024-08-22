package com.example.springboot.test;

import com.example.springbootweb.model.Student;
import com.example.springbootweb.repository.StudentRepository;
import com.example.springbootweb.service.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = JunitTest.class)
@RunWith(SpringRunner.class)
public class JunitTest {

    @Mock
    StudentRepository repository;
    @InjectMocks
    StudentServiceImpl studentservice;
//    @Autowired
//    MockMvc mockMvc;

    @Before
    public void setUp() {

    }

    @Test
    public void save() {
        Student student = new Student();
        student.setId(1);
        student.setName("javed");
        student.setEmail("javed@gmail.com");
        student.setAge(34);
//        student.setAddress("Kolkata");
        student.setContact_no("8976543210");

        when(repository.save(student)).thenReturn(student);
        Student student1 = studentservice.save(student);
        //Assertions.assertEquals(2,student1.getId());
        Assertions.assertEquals("javed", student1.getName());
    }

    @Test
    public void getAllStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName("javed");
        student.setEmail("javed@gmail.com");
        student.setAge(34);
//        student.setAddress("Kolkata");
        student.setContact_no("8976543210");

        Student student1 = new Student();
        student1.setId(2);
        student1.setName("anika");
        student1.setEmail("anika@gmail.com");
        student1.setAge(28);
//        student1.setAddress("burdwan");
        student1.setContact_no("9591462540");

        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        when(repository.findAll()).thenReturn(list);
        List<Student> actualStudents = studentservice.getStudent();
        Assertions.assertEquals(list.size(), actualStudents.size());
        //verify(repository).findAll();

    }

    @Test
    public void getStudentById() {
        Student student = new Student();
        student.setId(1);
        student.setName("javed");
        student.setEmail("javed@gmail.com");
        student.setAge(34);
//        student.setAddress("Kolkata");
        student.setContact_no("8976543210");
        when(repository.findById(1)).thenReturn(Optional.of(student));

        Student s1 = studentservice.getStudentById(1);
        Assertions.assertEquals("javed@gmail.com", s1.getEmail());

    }

    @Test
    public void deleteTest() {
        Student student = new Student();
        student.setId(1);
        student.setName("javed");
        student.setEmail("javed@gmail.com");
        student.setAge(34);
//        student.setAddress("Kolkata");
        student.setContact_no("8976543210");
        // when(repository.save(student)).thenReturn(student);
        studentservice.delStudentById(1);
        verify(repository, times(1)).deleteById(1);
    }

//    @Test
//    public void testGetResourceById() throws Exception {
//        mockMvc.perform(get("/api/resource/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.name").value("Resource Name"));


    //}
}

