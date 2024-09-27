package com.africa.semicolon.wazobia_app.utils;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import com.africa.semicolon.wazobia_app.data.model.Routes;
import com.africa.semicolon.wazobia_app.dtos.request.BookARideRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;

public class Mapper {
    public static Passenger mapPassenger(RegistrationRequest request) {
        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getFirstName());
        passenger.setLastName(request.getLastName());
        passenger.setEmail(request.getEmail());
        passenger.setPhone(request.getPhone());
        passenger.setPassword(request.getPassword());
        passenger.setGender(request.getGender());
        passenger.setNextOfKinName(request.getNextOfKinName());
        passenger.setNextOfKinPhone(request.getNextOfKinPhone());
        return passenger;
    }
  
    public static Routes mapRoutes(BookARideRequest request) {
        Routes route = new Routes();
        route.setDeparture(request.getDepartureAddress());
        route.setDestination(request.getDestinationAddress());
        route.setDepartureTime(request.getDepartureTime());
        route.setPassengerId(request.getPassengerId());
        route.setDepartureDate(request.getDepartureDate());
        return route;
    }
}
