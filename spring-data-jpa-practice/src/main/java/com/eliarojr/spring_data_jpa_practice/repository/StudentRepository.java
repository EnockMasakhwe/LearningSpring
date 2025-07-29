package com.eliarojr.spring_data_jpa_practice.repository;

import com.eliarojr.spring_data_jpa_practice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstNameIgnoreCase(String firstName);
    List<Student> findByFirstNameContainingIgnoreCase(String firstName);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String name);
    List<Student> findByStudentIdBetween(Long studentIdAfter, Long studentIdBefore);
    Student findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);

}
