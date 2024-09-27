package com.africa.semicolon.wazobia_app.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddDriverRequest {
    private String userName;
    private String email;
    private String phoneNumber;
    private String address;
    private String licenseNumber;
}

