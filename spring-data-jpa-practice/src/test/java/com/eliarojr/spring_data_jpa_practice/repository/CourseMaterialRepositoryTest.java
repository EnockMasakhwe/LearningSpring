package com.eliarojr.spring_data_jpa_practice.repository;

import com.eliarojr.spring_data_jpa_practice.entity.Course;
import com.eliarojr.spring_data_jpa_practice.entity.CourseMaterial;
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
                .title("Java")
                .credit(7)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.java.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterial = courseMaterialRepository.findAll();
        System.out.println("courseMaterial = " + courseMaterial);
    }
}