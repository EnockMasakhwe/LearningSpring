package com.eliarojr.spring_data_jpa_practice.repository;

import com.eliarojr.spring_data_jpa_practice.entity.Course;
import com.eliarojr.spring_data_jpa_practice.entity.CourseMaterial;
import com.eliarojr.spring_data_jpa_practice.entity.Teacher;
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
    public void saveTeacher(){

        //Course
        Course sql = Course.builder()
                .title("SQL")
                .credit(7)
                .build();
        Course mongoDB = Course.builder()
                .title("MongoDB")
                .credit(6)
                .build();
        Course javaScript = Course.builder()
                .title("JavaScript")
                .credit(7)
                .build();

        //Teacher
        Teacher teacher = Teacher.builder()
                .firstName("Dev")
                .lastName("Tiro")
                .courses(List.of(sql, mongoDB, javaScript))
                .build();

        teacherRepository.save(teacher);
    }

    @Test
    public void deleteTeacher(){
        teacherRepository.deleteById(4L);
    }

}