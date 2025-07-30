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
        //Course material
//        CourseMaterial postMat = CourseMaterial.builder()
//                .url("www.postgresql.com")
//                .build();
//        CourseMaterial dockMat = CourseMaterial.builder()
//                .url("www.docker.com")
//                .build();
//        CourseMaterial cloudMat = CourseMaterial.builder()
//                .url("www.cloudcomputing.com")
//                .build();

        //Course
        Course postgreSQL = Course.builder()
                .title("PostgreSQL")
                .credit(7)
                //.courseMaterial(postMat)
                .build();
        Course docker = Course.builder()
                .title("Docker")
                .credit(6)
                //.courseMaterial(dockMat)
                .build();
        Course cloud = Course.builder()
                .title("Cloud Computing")
                .credit(7)
                //.courseMaterial(cloudMat)
                .build();

        //Teacher
        Teacher teacher = Teacher.builder()
                .firstName("Nelson")
                .lastName("Djalo")
                .courses(List.of(postgreSQL, docker, cloud))
                .build();

        teacherRepository.save(teacher);
    }

    @Test
    public void deleteTeacher(){
        teacherRepository.deleteById(4L);
    }

}