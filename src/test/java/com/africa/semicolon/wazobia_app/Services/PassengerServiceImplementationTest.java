package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.dtos.request.LoginPassengerRequest;
import com.africa.semicolon.wazobia_app.dtos.response.LoginResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PassengerServiceImplementationTest {
    @Autowired
    private  PassengerService passengerService;

    @BeforeEach
    void setUp() {
    }


}
