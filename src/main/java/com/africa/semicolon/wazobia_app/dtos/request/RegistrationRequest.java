package com.africa.semicolon.wazobia_app.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;
    private String password;
    private String nextOfKinName;
    private String nextOfKinPhone;
}
