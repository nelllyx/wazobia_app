package com.africa.semicolon.wazobia_app.Services;


import com.africa.semicolon.wazobia_app.data.model.Routes;
import com.africa.semicolon.wazobia_app.data.model.Trip;
import com.africa.semicolon.wazobia_app.data.repository.BookingRepository;
import com.africa.semicolon.wazobia_app.data.repository.RoutesRepository;
import com.africa.semicolon.wazobia_app.data.repository.TripRepository;
import com.africa.semicolon.wazobia_app.data.repository.VehiclesRepository;
import com.africa.semicolon.wazobia_app.dtos.request.BookARideRequest;
import com.africa.semicolon.wazobia_app.dtos.response.BookARideResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

import static com.africa.semicolon.wazobia_app.utils.Mapper.mapRoutes;
import static com.africa.semicolon.wazobia_app.utils.Mapper.mapTrip;

@Service @RequiredArgsConstructor


public class BookingServiceImpl implements BookingService {

    @Lazy
    private final RoutesRepository routesRepository;
    @Lazy
    private final TripRepository tripRepository;
    private final BookingRepository bookingRepository;
    private final VehiclesRepository vehiclesRepository;

    @Override
    public BookARideResponse bookARide(BookARideRequest request) {
        Routes route = mapRoutes(request);
        routesRepository.save(route);
        Trip trip = mapTrip(route, vehiclesRepository);
        tripRepository.save(trip);
        String date = route.getDepartureDate().toString();
        String time = route.getDepartureTime().toString();
        String startingPoint = route.getDeparture();
        String endingPoint = route.getDestination();

        BookARideResponse response = new BookARideResponse();
        String bookingInfo = String.format("""
                Booking successful!
                Your trip from %s to %s has been confirmed for %s at %s
                Head to the Payment Page to Make Payment And Get More
                Infomation About your trip
                """,startingPoint,endingPoint,date,time);
        response.setBookingInfo(bookingInfo);
//        bookingRepository.save()







        return response;
    }
}
