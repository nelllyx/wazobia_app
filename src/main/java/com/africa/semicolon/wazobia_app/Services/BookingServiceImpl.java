package com.africa.semicolon.wazobia_app.Services;


import com.africa.semicolon.wazobia_app.data.model.Routes;
import com.africa.semicolon.wazobia_app.data.model.Trip;
import com.africa.semicolon.wazobia_app.data.repository.RoutesRepository;
import com.africa.semicolon.wazobia_app.data.repository.TripRepository;
import com.africa.semicolon.wazobia_app.dtos.request.BookARideRequest;
import com.africa.semicolon.wazobia_app.dtos.response.BookARideResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

import static com.africa.semicolon.wazobia_app.utils.Mapper.mapRoutes;

@Service @RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Lazy
    private final RoutesRepository routesRepository;
    @Lazy
    private final TripRepository tripRepository;

    @Override
    public BookARideResponse bookARide(BookARideRequest request) {
        Routes route = mapRoutes(request);
        Long vehicleId = 1L;
        if(route.getDepartureTime().equals( LocalTime.of(6, 30))) vehicleId = 1L;
        if(route.getDepartureTime().equals( LocalTime.of(10, 30))) vehicleId = 2L;
        if(route.getDepartureTime().equals( LocalTime.of(20, 30))) vehicleId = 3L;
        if(route.getDepartureTime().equals( LocalTime.of(22, 30))) vehicleId = 4L;
        LocalTime  arrivalTime = LocalTime.of(22, 30);
        routesRepository.save(route);
        Trip trip = new Trip();
        trip.setRouteId(route.getRouteId());
        trip.setDepartureTime(route.getDepartureTime());
        trip.setVehiclesId(vehicleId);
        tripRepository.save(trip);
        String date;
        String startingPoint = route.getDeparture();
        String endingPoint = route.getDestination();

        BookARideResponse response = new BookARideResponse();
//        String bookingInfo = String.format("""
//                Booking successful!
//                Your trip from %s to %s is confirmed for %s at %
//                """,route.getStartingPoint(),route.getEndingPoint(),route.getDepartureDate(),);
        response.setBookingInfo("hhh");






        return response;
    }
}
