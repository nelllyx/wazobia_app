package com.africa.semicolon.wazobia_app.utils;

import com.africa.semicolon.wazobia_app.data.model.*;
import com.africa.semicolon.wazobia_app.dtos.request.AddDriverRequest;
import com.africa.semicolon.wazobia_app.dtos.request.AddVehicleRequest;
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
        route.setDeparture(request.getDepatureAddress());
        route.setDestination(request.getDestinationAdress());
        route.setDepartureTime(request.getDepatureTime());
        route.setPassengerId(request.getPassengerId());
        route.setDepartureDate(request.getDepartureDate());
        return route;
    }

    public static Driver mapDriver(AddDriverRequest request){
        Driver driver = new Driver();
        driver.setDriverName(request.getUserName());
        driver.setEmail(request.getEmail());
        driver.setPhoneNumber(request.getPhoneNumber());
        driver.setAddress(request.getAddress());
        driver.setLicenseNumber(request.getLicenseNumber());
        return driver;

    }

    public static Vehicles mapVehicle(AddVehicleRequest request){
        Vehicles vehicle = new Vehicles();
        vehicle.setMake(request.getMake());
        vehicle.setModel(request.getModel());
        vehicle.setNumberOfSits(request.getNumberOfSeats());
        vehicle.setPlateNumber(request.getPlateNumber());
        return vehicle;
    }


}
