package com.eliarojr.college_database.repository;

import com.eliarojr.college_database.entity.Course;
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

}