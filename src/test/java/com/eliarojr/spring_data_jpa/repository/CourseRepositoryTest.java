package com.eliarojr.spring_data_jpa.repository;

import com.eliarojr.spring_data_jpa.entity.Course;
import com.eliarojr.spring_data_jpa.entity.Teacher;
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
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Jane")
                .lastName("Kimani")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

}