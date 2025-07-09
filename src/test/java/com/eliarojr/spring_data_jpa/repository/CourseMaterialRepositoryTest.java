package com.eliarojr.spring_data_jpa.repository;

import com.eliarojr.spring_data_jpa.entity.Course;
import com.eliarojr.spring_data_jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("Google Fundamentals")
                .credit(1)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("www.google.com")
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

}