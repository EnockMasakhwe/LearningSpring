package com.eliarojr.college_database.repository;

import com.eliarojr.college_database.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstName("Raila")
                .lastName("Odinga")
                .emailId("raila@gmail,com")
                .guardianName("Jaramogi Oginga")
                .guardianEmail("jaramogi@gmail.com")
                .guardianMobile("0756438712")
                .build();
        studentRepository.save(student);

    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

}