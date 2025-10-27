package com.eliarojr.college_database.repository;

import com.eliarojr.college_database.entity.Guardian;
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
//                .guardianName("Jaramogi Oginga")
//                .guardianEmail("jaramogi@gmail.com")
//                .guardianMobile("0756438712")
                .build();
        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Raila Odinga")
                .email("raila@gmail.com")
                .mobile("0897654367")
                .build();

        Student student = Student.builder()
                .firstName("Raila")
                .lastName("Junior")
                .emailId("junior@gmail.com")
                .guardian(guardian)
                .build();

       studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
    
    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Raila");
        System.out.println("studentList = " + studentList);
    }
    
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("rai");
        System.out.println("studentList = " + studentList);
    }
    
    @Test
    public void printStudentByLastNameIgnoreCase(){
        List<Student> studentList = studentRepository.findByLastNameIgnoreCase("odinga");
        System.out.println("studentList = " + studentList);
    }
    
    @Test
    public void printStudentByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Raila Odinga");
        System.out.println("studentList = " + studentList);
    }
    
    @Test
    public void printStudentBySecondNameNotNull(){
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("Raila","Odinga");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("junior@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public  void printStudentFirstNameByEmailId(){
        String firstname = studentRepository.getStudentFirstNameByEmailAddress("raila@gmail,com");
        System.out.println("firstname = " + firstname);
    }

    @Test
    public  void printStudentByEmailIdNative(){
        Student firstname = studentRepository.getStudentByEmailAddressNative("raila@gmail,com");
        System.out.println("firstname = " + firstname);
    }

    @Test
    public  void printStudentFirstNameByEmailIdNative(){
        String firstname = studentRepository.getStudentFirstNameByEmailAddressNative("raila@gmail,com");
        System.out.println("firstname = " + firstname);
    }

    @Test
    public  void printStudentFirstNameByEmailIdNativeNamedParam(){
        String firstname = studentRepository.getStudentFirstNameByEmailAddressNativeNamedParam("raila@gmail,com");
        System.out.println("firstname = " + firstname);
    }
    

}