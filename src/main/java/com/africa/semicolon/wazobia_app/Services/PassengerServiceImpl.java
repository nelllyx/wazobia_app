package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;

import static com.africa.semicolon.wazobia_app.utils.Mapper.map;

public class PassengerServiceImpl implements PassengerService {

    @Override
    public RegistrationResponse addPassenger(RegistrationRequest register) {
        Passenger request = map(register);

        RegistrationResponse response = new RegistrationResponse();
        response.setMessage("You have successfully added passenger");
        return response;
    }
}
