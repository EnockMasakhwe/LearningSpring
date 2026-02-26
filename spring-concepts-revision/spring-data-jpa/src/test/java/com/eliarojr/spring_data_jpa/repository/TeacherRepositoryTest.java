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
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void saveTeacher(){
        CourseMaterial courseMaterialOOP = CourseMaterial.builder()
                .url("www.javaoop.com")
                .build();
        Course courseOOP = Course.builder()
                .courseTitle("Java OOP")
                .credit(7)
                .courseMaterial(courseMaterialOOP)
                .build();

        CourseMaterial courseMaterialC = CourseMaterial.builder()
                .url("www.cprogramming.com")
                .build();
        Course courseC = Course.builder()
                .courseTitle("C Programming")
                .credit(8)
                .courseMaterial(courseMaterialC)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("James")
                .lastName("Oyugi")
                //.courseList(List.of(courseOOP, courseC))
                .build();

        teacherRepository.save(teacher);
    }

}