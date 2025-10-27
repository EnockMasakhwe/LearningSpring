package com.eliarojr.college_database.repository;

import com.eliarojr.college_database.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameIgnoreCase(String lastName);

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByLastNameNotNull();

    Student findByFirstNameAndLastName(String firstName, String lastName);


    //JPQL queries - uses class names and attributes
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //Native queries - uses table and column names
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    @Query(
            value = "SELECT s.first_name FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    String getStudentFirstNameByEmailAddressNative(String emailId);

}
