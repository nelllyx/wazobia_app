package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;

public interface PassengerService {
    RegistrationResponse addPassenger(RegistrationRequest request);
}
