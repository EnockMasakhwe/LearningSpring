package com.eliarojr.spring_data_jpa.repository;

import com.eliarojr.spring_data_jpa.entity.Course;
import com.eliarojr.spring_data_jpa.entity.CourseMaterial;
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
    void saveCourse(){
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
}