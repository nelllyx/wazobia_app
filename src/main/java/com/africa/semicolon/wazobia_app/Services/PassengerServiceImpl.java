package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import com.africa.semicolon.wazobia_app.data.repository.PassengerRepository;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.africa.semicolon.wazobia_app.utils.Mapper.mapPassenger;


@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public RegistrationResponse addPassenger(RegistrationRequest register) {
        Passenger passenger = mapPassenger(register);
        passengerRepository.save(passenger);

        RegistrationResponse response = new RegistrationResponse();

        response.setMessage("You have successfully added passenger");
        response.setUserId(passenger.getId());
        return response;
    }
}
