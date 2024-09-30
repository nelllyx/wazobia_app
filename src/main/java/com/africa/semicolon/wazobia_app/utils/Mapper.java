package com.africa.semicolon.wazobia_app.utils;

import com.africa.semicolon.wazobia_app.data.model.*;
import com.africa.semicolon.wazobia_app.data.repository.VehiclesRepository;
import com.africa.semicolon.wazobia_app.dtos.request.AddDriverRequest;
import com.africa.semicolon.wazobia_app.dtos.request.AddVehicleRequest;
import com.africa.semicolon.wazobia_app.dtos.request.BookARideRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static com.africa.semicolon.wazobia_app.utils.SimpleHash.decrypt;


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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(request.getDepartureTime(), formatter);
        ZonedDateTime zonedDateTime = localTime.atDate(LocalDate.now()) // Add current date
                .atZone(ZoneId.systemDefault());
        route.setDepartureTime(zonedDateTime.toLocalTime());
        System.out.println(request.getPassengerId());
        route.setPassengerId(decrypt(request.getPassengerId()));
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-dd-MM");
        LocalDate localDate = LocalDate.parse(request.getDepartureDate(), formatter1);
        route.setDepartureDate(localDate);
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
        vehicle.setNumberOfSeat(request.getNumberOfSeats());
        vehicle.setPlateNumber(request.getPlateNumber());
        return vehicle;
    }

    public static Trip mapTrip(Routes route, VehiclesRepository repository){
        Long vehicleId = 1L;
        if(route.getDepartureTime().equals( LocalTime.of(6, 30))) vehicleId = 1L;
        if(route.getDepartureTime().equals( LocalTime.of(10, 30))) vehicleId = 2L;
        if(route.getDepartureTime().equals( LocalTime.of(20, 30))) vehicleId = 3L;
        if(route.getDepartureTime().equals( LocalTime.of(22, 30))) vehicleId = 4L;
//        LocalTime  arrivalTime = LocalTime.of(22, 30);
        Trip trip = new Trip();
        trip.setRouteId(route.getRouteId());
        trip.setDepartureTime(route.getDepartureTime());
        trip.setVehiclesId(vehicleId);
        Vehicles vehicle = repository.findVehicleById(vehicleId);
        trip.setDriverId(vehicle.getDriverId());
        return trip;

    }






}
