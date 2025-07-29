package com.eliarojr.spring_data_jpa_practice.repository;

import com.eliarojr.spring_data_jpa_practice.entity.Guardian;
import com.eliarojr.spring_data_jpa_practice.entity.Student;
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
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("modric@gmail.com")
                .firstName("Luca")
                .lastName("Modric")
                //.guardianName("Xabi")
                //.guardianEmail("alonso@gmail.com")
                //.guardianMobile("0712345678")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Xabi")
                .email("alonso@gmail.com")
                .mobile("0712345678")
                .build();

        Student student = Student.builder()
                .firstName("Toni")
                .lastName("Kroos")
                .emailId("kroos@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List <Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
}