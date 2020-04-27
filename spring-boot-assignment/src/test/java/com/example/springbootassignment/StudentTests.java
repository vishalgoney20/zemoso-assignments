package com.example.springbootassignment;

import com.example.springbootassignment.dao.StudentRepository;
import com.example.springbootassignment.entity.Student;
import com.example.springbootassignment.service.StudentService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class StudentTests {

    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Test
    public void findAllTest() {

        Mockito.when(studentRepository.findAll()).thenReturn(Stream.of(new Student("jon","snow","jon@gmail.com"),
                new Student("arya","stark","arya@gmail.com"),new Student("sansa","stark","sansa@gmail.com")
        ).collect(Collectors.toList()));
        Assert.assertEquals(3,studentService.findAll().size());
    }

    @Test
    public void findByIdTest(){
        int id=1;
        Student theStudent=new Student("jon","snow","jon@gmail.com");

        Mockito.when(studentRepository.findById(id)).thenReturn(Optional.of(theStudent));
        Assert.assertEquals("jon",studentService.findById(id).getFirstName());
    }

    @Test
    public void saveTest(){
        Student theStudent=new Student("cersei","lannister","cersei@gmail.com");
        Mockito.when(studentRepository.save(theStudent)).thenReturn(theStudent);
        Assert.assertEquals(theStudent,studentService.save(theStudent));
    }

    @Test
    public void deleteTest(){
        Student theStudent=new Student("cersei","lannister","cersei@gmail.com");
        studentService.deleteById(theStudent.getId());
        Mockito.verify(studentRepository,Mockito.times(1)).deleteById(theStudent.getId());
    }


}
