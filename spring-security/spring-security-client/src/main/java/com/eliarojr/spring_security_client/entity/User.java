package com.eliarojr.spring_security_client.entity;

import jakarta.persistence.*;
import lombok.Data;
//User entity
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Column(length = 60)
    private String password;
    private String role;
    private boolean enabled = false;
}
