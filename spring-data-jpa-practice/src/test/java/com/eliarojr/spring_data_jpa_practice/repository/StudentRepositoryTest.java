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
                .firstName("Karim")
                .lastName("Benzema")
                .emailId("benzema@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List <Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List <Student> studentList = studentRepository.findByFirstNameIgnoreCase("luca");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List <Student> studentList = studentRepository.findByFirstNameContainingIgnoreCase("lu");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByLastName(){
        List <Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentsById(){
        List <Student> studentList = studentRepository.findByStudentIdBetween(1L,50L);
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByGuardianName(){
        List <Student> studentList = studentRepository.findByGuardianName("Xabi");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstNameAndLastName(){
        Student studentList = studentRepository.findByFirstNameAndLastNameIgnoreCase("luca","modric");
        System.out.println("studentList = " + studentList);
    }

    //JPQL
    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("kroos@gmail.com");
        System.out.println("student = " + student);
    }

    //JPQL
    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("mbappe@gmail.com");
        System.out.println("firstName = " + firstName);
    }

    //Native
    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("kroos@gmail.com");
        System.out.println("student = " + student);
    }

    //Native named param
    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("mbappe@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentFirstNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("Lukita","modric@gmail.com");

    }



}