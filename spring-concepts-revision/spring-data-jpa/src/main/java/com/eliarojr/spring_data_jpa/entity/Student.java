package com.eliarojr.spring_data_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(
            name = "email_address",
            unique = true,
            nullable = false
    )
    private String emailId;


    private String guardianName;
    private String guardianEmail;
    private  String guardianMobile;
}
