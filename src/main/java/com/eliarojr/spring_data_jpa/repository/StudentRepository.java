package com.eliarojr.spring_data_jpa.repository;

import com.eliarojr.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //JPA methods
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String firstName);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String name);

    //JQL
    @Query("Select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("Select s.firstName from Student s where s.emailId = ?1")
    String  getStudentFirstNameByEmailAddress(String emailId);

    //Native Queries
    @Query(
            value =  "SELECT * FROM tbl_student s where  s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //Native, named params
    @Query(
            value =  "SELECT * FROM tbl_student s where  s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    //Updating data in the DB
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    void updateStudentNameByEmailId(String firstName, String emailId);
}
