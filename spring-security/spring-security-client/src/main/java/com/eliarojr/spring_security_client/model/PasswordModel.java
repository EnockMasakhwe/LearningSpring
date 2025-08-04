package com.eliarojr.spring_security_client.model;

import lombok.Data;
//Model
@Data
public class PasswordModel {

    private String email;
    private String oldPassword;
    private String newPassword;
}
