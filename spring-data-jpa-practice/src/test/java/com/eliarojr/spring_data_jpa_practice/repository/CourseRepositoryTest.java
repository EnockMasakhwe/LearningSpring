package com.eliarojr.spring_data_jpa_practice.repository;

import com.eliarojr.spring_data_jpa_practice.entity.Course;
import com.eliarojr.spring_data_jpa_practice.entity.Teacher;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
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

        /*Course sql = Course.builder()
                .title("SQL")
                .credit(7)
                .teacher(teacher)
                .build();
        Course mongoDB = Course.builder()
                .title("MongoDB")
                .credit(6)
                .teacher(teacher)
                .build();
         */
        Course mariaDB = Course.builder()
                .title("MariaDB")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(mariaDB);
    }
    
    @Test
    public void findAllPagination(){
        PageRequest firstPageWithThreeRecords = PageRequest.of(0,3);
        PageRequest secondPageWithTwoRecords = PageRequest.of(1,2);
        
        Page <Course> page = courseRepository.findAll(secondPageWithTwoRecords);

        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Course> courseList = page.getContent();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courseList);
        
    }

    @Test
    public void findAllSorting(){
        PageRequest sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        PageRequest sortByCreditDesc = PageRequest.of(0,2,Sort.by("credit").descending());
        PageRequest sortByTitleAndCreditDesc = PageRequest.of(0,2,Sort.by("title").descending().and(Sort.by("credit")));

        List <Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        PageRequest firstPageTenRecords = PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("M",firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }


}