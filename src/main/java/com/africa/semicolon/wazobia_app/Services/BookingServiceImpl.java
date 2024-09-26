package com.africa.semicolon.wazobia_app.Services;


import com.africa.semicolon.wazobia_app.data.model.Routes;
import com.africa.semicolon.wazobia_app.data.model.Trip;
import com.africa.semicolon.wazobia_app.data.repository.BookingRepository;
import com.africa.semicolon.wazobia_app.data.repository.RoutesRepository;
import com.africa.semicolon.wazobia_app.dtos.request.BookARideRequest;
import com.africa.semicolon.wazobia_app.dtos.response.BookARideResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.RouteMatcher;

import static com.africa.semicolon.wazobia_app.utils.Mapper.mapRoutes;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    RoutesRepository routesRepository;


    @Override
    public BookARideResponse bookARide(BookARideRequest request) {
        Routes route = mapRoutes(request);
        routesRepository.save(route);
        Trip trip = new Trip();
        trip.setRouteId(route.getRouteId());
        trip.setDepartureTime(route.getDepatureTime());
//        trip.setVehiclesId();
//        trip.setArrivalTime();




        return null;
    }
}
