package com.africa.semicolon.wazobia_app.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginPassengerRequest {
    private String email;
    private String password;
}
