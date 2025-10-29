package com.eliarojr.college_database.repository;

import com.eliarojr.college_database.entity.Course;
import com.eliarojr.college_database.entity.CourseMaterial;
import com.eliarojr.college_database.entity.Teacher;
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

}