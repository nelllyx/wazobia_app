package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import com.africa.semicolon.wazobia_app.dtos.request.LoginPassengerRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.LoginResponse;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;
import org.springframework.stereotype.Service;

import static com.africa.semicolon.wazobia_app.utils.Mapper.map;
@Service
public class PassengerServiceImpl implements PassengerService {

    @Override
    public RegistrationResponse addPassenger(RegistrationRequest register) {
        Passenger request = map(register);

        RegistrationResponse response = new RegistrationResponse();
        response.setMessage("You have successfully added passenger");
        return response;
    }

    @Override
    public LoginResponse loginPassenger(LoginPassengerRequest login){
        Passenger request = map(login);

        LoginResponse response = new LoginResponse();
        response.setMessage("You have successfully logged in");
        return response;
    }
}
