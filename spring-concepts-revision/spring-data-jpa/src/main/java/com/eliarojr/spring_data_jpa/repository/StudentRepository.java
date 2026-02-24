package com.eliarojr.spring_data_jpa.repository;

import com.eliarojr.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByFirstName(String firstName);

    Student findByFirstNameIgnoreCase(String firstName);

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByEmailIdContaining(String emailId);

}
