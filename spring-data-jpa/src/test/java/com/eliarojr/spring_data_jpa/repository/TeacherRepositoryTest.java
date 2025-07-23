package com.eliarojr.spring_data_jpa.repository;

import com.eliarojr.spring_data_jpa.entity.Course;
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
    public void saveTeacher(){

        Course courseDSA = Course.builder()
                .title("DSA")
                .credit(2)
                .build();

        Course courseSTACS = Course.builder()
                .title("STACS")
                .credit(3)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("James")
                .lastName("Oyugi")
                //.courses(List.of(courseDSA, courseSTACS))
                .build();

        teacherRepository.save(teacher);
    }
}