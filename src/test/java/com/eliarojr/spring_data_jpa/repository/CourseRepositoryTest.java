package com.eliarojr.spring_data_jpa.repository;

import com.eliarojr.spring_data_jpa.entity.Course;
import com.eliarojr.spring_data_jpa.entity.Student;
import com.eliarojr.spring_data_jpa.entity.Teacher;
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

    @Test
    public void deleteCourseWithTeacher(){
        courseRepository.deleteById(6L);
    }

    @Test
    public void findAllPagination() {
        PageRequest firstPageWithThreeRecords = PageRequest.of(0,3);
        PageRequest secondPageWithTwoRecords = PageRequest.of(1, 2);

        Page<Course> page = courseRepository.findAll(secondPageWithTwoRecords);

        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Course> courses = page.getContent();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        PageRequest sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        PageRequest sortByCreditDesc = PageRequest.of(0,2,Sort.by("credit").descending());
        PageRequest sortByTitleAndCreditDesc = PageRequest.of(0,2,Sort.by("true").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        PageRequest firstPageTenRecords = PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("D",firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Philip")
                .lastName("Oyier")
                .build();

        Student student = Student.builder()
                .firstName("Jude")
                .lastName("Bellingham")
                .emailId("bellingham@gmail.com")
                .build();

        Course course = Course.builder()
                .credit(5)
                .title("AI")
                .teacher(teacher)
                .build();
        course.addStudents(student);

        courseRepository.save(course);
    }


}