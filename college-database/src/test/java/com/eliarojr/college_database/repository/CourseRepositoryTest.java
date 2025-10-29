package com.eliarojr.college_database.repository;

import com.eliarojr.college_database.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Test
    public void printAllCourses(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println("courseList = " + courseList);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("James")
                .lastName("Oyugi")
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.c#.com")
                .build();
        Course course = Course.builder()
                .courseTitle("C#")
                .credit(7)
                .courseMaterial(courseMaterial)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void addCourseWithStudent(){
        Guardian guardian = Guardian.builder()
                .name("Raila")
                .mobile("0899653421")
                .email("raila@gmail.com")
                .build();
        Student student = Student.builder()
                .firstName("Winnie")
                .lastName("Odinga")
                .emailId("winnie@gmail.com")
                .guardian(guardian)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Teddy")
                .lastName("Nevin")
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.ruby.com")
                .build();
        Course course = Course.builder()
                .courseTitle("Ruby")
                .credit(9)
                .courseMaterial(courseMaterial)
                .teacher(teacher)
                .build();

        course.addStudents(student);
        courseRepository.save(course);
    }

}