package com.africa.semicolon.wazobia_app.dtos.request;

import lombok.Data;

@Data
public class RegisterAdminRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
}
