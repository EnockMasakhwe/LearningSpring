package com.eliarojr.spring_data_jpa_practice.repository;

import com.eliarojr.spring_data_jpa_practice.entity.Course;
import com.eliarojr.spring_data_jpa_practice.entity.Teacher;
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
      List <Course>course = courseRepository.findAll();
      System.out.println("course = " + course);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Steve")
                .lastName("Curry")
                .build();

        Course sql = Course.builder()
                .title("SQL")
                .credit(7)
                .teacher(teacher)
                .build();
        Course mongoDB = Course.builder()
                .title("MongoDB")
                .credit(6)
                .teacher(teacher)
                .build();
        Course mariaDB = Course.builder()
                .title("MariaDB")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(mariaDB);
    }


}