package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import com.africa.semicolon.wazobia_app.dtos.request.BookARideRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.BookARideResponse;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BookingServiceImplTest {
    @Autowired
    BookingServiceImpl bookingService;

    @Autowired
    PassengerServiceImpl passengerService;

    @Test
    public void testThatAUserCanBookATrip(){
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstName("Alex");
        registrationRequest.setLastName("Smith");
        registrationRequest.setEmail("alex.smith@gmail.com");
        registrationRequest.setPhone("08084563215");
        registrationRequest.setPassword("freddie");
        registrationRequest.setNextOfKinName("buhari");
        registrationRequest.setNextOfKinPhone("09099336622");
        RegistrationResponse response = passengerService.addPassenger(registrationRequest);
        BookARideRequest request = new BookARideRequest();
        request.setPassengerId(response.getUserId());
        request.setDestinationAdress("oyo, ibadan");
        request.setDepatureAddress("lagos yaba");
        request.setDepatureTime(LocalTime.of(6,0));
        request.setDepartureDate(LocalDate.of(2024,10,27));
        BookARideResponse response1 = bookingService.bookARide(request);
        assertThat(response1).isNotNull();
    }

}