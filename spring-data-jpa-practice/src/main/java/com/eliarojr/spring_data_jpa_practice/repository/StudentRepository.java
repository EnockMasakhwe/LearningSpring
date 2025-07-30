package com.eliarojr.spring_data_jpa_practice.repository;

import com.eliarojr.spring_data_jpa_practice.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    //JPQL
    @Query("select s from Student  s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from Student  s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //Native
    @Query(
            value = "SELECT * FROM universitydb.tbl_university s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //Native named param
    @Query(
            value = "SELECT * FROM universitydb.tbl_university s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Transactional
    @Modifying
    @Query("update Student s set s.firstName = :firstName where s.emailId = :emailId")
    void updateStudentNameByEmailId(@Param("firstName") String firstName, @Param("emailId") String emailId);


}
