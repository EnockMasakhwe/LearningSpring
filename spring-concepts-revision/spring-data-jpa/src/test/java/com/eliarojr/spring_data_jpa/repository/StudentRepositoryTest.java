package com.eliarojr.spring_data_jpa.repository;

import com.eliarojr.spring_data_jpa.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void saveStudent() {
        Student student = Student.builder()
                .firstName("Grace").lastName("Masakhwe").emailId("gracemasakhwe@gmail.com")
                .guardianName("Samuel Masakhwe").guardianEmail("samueleliaro@gmail.com").guardianMobile("0720753093")
                .build();

        studentRepository.save(student);
    }

    @Test
    void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    void printStudentById(){
        Student student = studentRepository.findById(4L).get();
        System.out.println("student = " + student);
    }

}