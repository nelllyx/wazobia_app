package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import com.africa.semicolon.wazobia_app.data.repository.PassengerRepository;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;
import com.africa.semicolon.wazobia_app.exceptions.WazobiaException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.africa.semicolon.wazobia_app.utils.Mapper.mapPassenger;
@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    @Override
    public RegistrationResponse addPassenger(RegistrationRequest register) {
        Passenger request = mapPassenger(register);
        if(passengerRepository.existsByEmail(request.getEmail())|| passengerRepository.existsByPhone(request.getPhone())) {
            throw new WazobiaException("User already exists");
        }else {
            passengerRepository.save(request);
        }
        RegistrationResponse response = new RegistrationResponse();
        response.setMessage("You have successfully added passenger");
        return response;
    }

  
}
