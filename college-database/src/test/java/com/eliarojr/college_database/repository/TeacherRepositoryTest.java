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
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherWithCourse(){
        CourseMaterial material1 = CourseMaterial.builder()
                .url("www.dsanotes.com")
                .build();
        Course course1 = Course.builder()
                .courseTitle("DSA")
                .credit(6)
                .courseMaterial(material1)
                .build();

        CourseMaterial material2 = CourseMaterial.builder()
                .url("www.dbacourse.com")
                .build();
        Course course2 = Course.builder()
                .courseTitle("DBA")
                .credit(5)
                .courseMaterial(material2)
                .build();

        CourseMaterial material3 = CourseMaterial.builder()
                .url("www.aws/ml.com")
                .build();
        Course course3 = Course.builder()
                .courseTitle("ML")
                .credit(6)
                .courseMaterial(material3)
                .build();

        CourseMaterial material4 = CourseMaterial.builder()
                .url("www.was/ai.com")
                .build();
        Course course4 = Course.builder()
                .courseTitle("AI")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Shabbir")
                .lastName("Dawoodi")
                //.courses(List.of(course1,course2,course3,course4))
                .build();

        teacherRepository.save(teacher);
    }

}