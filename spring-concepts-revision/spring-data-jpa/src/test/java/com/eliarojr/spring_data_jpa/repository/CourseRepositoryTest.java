package com.eliarojr.spring_data_jpa.repository;

import com.eliarojr.spring_data_jpa.entity.Course;
import com.eliarojr.spring_data_jpa.entity.CourseMaterial;
import com.eliarojr.spring_data_jpa.entity.Student;
import com.eliarojr.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private  CourseRepository courseRepository;

    @Test
    void printCourses(){
        List<Course> course = courseRepository.findAll();
        System.out.println("course = " + course);
    }

    @Test
    void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Jane")
                .lastName("Kimani")
                .build();
        CourseMaterial courseMaterialPython = CourseMaterial.builder()
                .url("www.python.com")
                .build();
        Course course = Course.builder()
                .courseTitle("Python")
                .credit(8)
               // .courseMaterial(courseMaterialPython)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Vincent").
                lastName("Mwai").
                build();

        Student student1 = Student.builder()
                .firstName("Paul")
                .lastName("Mbarire")
                .emailId("paulmbarire@gmail.com")
                .build();
        Student student2 = Student.builder()
                .firstName("Benedict")
                .lastName("Makau")
                .emailId("benedictmakau@gmail.com")
                .build();
        Student student3 = Student.builder()
                .firstName("Ian")
                .lastName("Njogu")
                .emailId("iannjogu@gmail.com")
                .build();

        Course course = Course.builder()
                .courseTitle("AI & ML")
                .credit(9)
                .teacher(teacher)
                .studentList(List.of(student1, student2, student3))
                .build();

        courseRepository.save(course);
    }
}