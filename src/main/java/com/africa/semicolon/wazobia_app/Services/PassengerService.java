package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.dtos.request.BookARideRequest;
import com.africa.semicolon.wazobia_app.dtos.request.LoginPassengerRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.BookARideResponse;
import com.africa.semicolon.wazobia_app.dtos.response.LoginPassengerResponse;
import com.africa.semicolon.wazobia_app.dtos.response.LoginResponse;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;

public interface PassengerService {
    RegistrationResponse addPassenger(RegistrationRequest request);


    LoginPassengerResponse loginPassenger(LoginPassengerRequest request);

    BookARideResponse bookARide(BookARideRequest request2);
}
