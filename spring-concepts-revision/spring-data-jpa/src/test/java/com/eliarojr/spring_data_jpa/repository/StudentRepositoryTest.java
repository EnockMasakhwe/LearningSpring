package com.eliarojr.spring_data_jpa.repository;

import com.eliarojr.spring_data_jpa.entity.Guardian;
import com.eliarojr.spring_data_jpa.entity.Student;
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
                .firstName("Grace")
                .lastName("Masakhwe")
                .emailId("gracemasakhwe@gmail.com")
                //.guardianName("Samuel Masakhwe")
                //.guardianEmail("samueleliaro@gmail.com")
                //.guardianMobile("0720753093")
                .build();

        studentRepository.save(student);
    }

    @Test
    void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Grace Masakhwe")
                .emailAddress("gracemasakhwe@gmail.com")
                .mobileNumber("0798131021")
                .build();

        Student student = Student.builder()
                .firstName("John")
                .lastName("Lyimo")
                .emailId("johnlyimo@gmail.com")
                .guardian(guardian)
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

    @Test
    void printStudentByFirstName(){
        Student student = studentRepository.findByFirstName("enock");
        System.out.println("student = " + student);
    }
    @Test
     void printStudentByFirstNameIgnoreCase(){
        Student student = studentRepository.findByFirstNameIgnoreCase("faith");
         System.out.println("student = " + student);
     }

     @Test
     void printStudentByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Samuel Masakhwe");
         System.out.println("student = " + studentList);
     }

     @Test
     void printStudentByEmailIdContaining(){
        List<Student> studentList = studentRepository.findByEmailIdContaining("eliaro");
         System.out.println("studentList = " + studentList);
     }

     @Test
     void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("enockeliaro@gmail.com");
         System.out.println("student = " + student);
     }

     @Test
     void printGetStudentFirstNameByEmailAddress(){
        String student = studentRepository.getStudentFirstNameByEmailAddress("enockeliaro@gmail.com");
         System.out.println("student = " + student);
     }

    @Test
    void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("enockeliaro@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    void printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("enockeliaro@gmail.com");
        System.out.println("student = " + student);
    }



}