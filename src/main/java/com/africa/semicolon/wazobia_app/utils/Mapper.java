package com.africa.semicolon.wazobia_app.utils;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import com.africa.semicolon.wazobia_app.dtos.request.LoginPassengerRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;

public class Mapper {
    public static Passenger map(RegistrationRequest request) {
        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getFirstName());
        passenger.setLastName(request.getLastName());
        passenger.setEmail(request.getEmail());
        passenger.setPhone(request.getPhone());
        passenger.setPassword(request.getPassword());
        passenger.setNextOfKinName(request.getNextOfKinName());
        passenger.setNextOfKinPhone(request.getNextOfKinPhone());

        return passenger;
    }
    public static Passenger map(LoginPassengerRequest request) {
        Passenger passenger = new Passenger();
        passenger.setEmail(request.getEmail());
        passenger.setPassword(request.getPassword());
        return passenger;
    }
}
