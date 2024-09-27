package com.africa.semicolon.wazobia_app.Services;


import com.africa.semicolon.wazobia_app.data.repository.PassengerRepository;
import com.africa.semicolon.wazobia_app.data.repository.RoutesRepository;
import com.africa.semicolon.wazobia_app.data.repository.TripRepository;
import com.africa.semicolon.wazobia_app.dtos.request.BookARideRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.BookARideResponse;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest

class BookingServiceImplTest {



//    public  PassengerRepository passengerRepository;
//
//    public  RoutesRepository routesRepository;
//
//    public  TripRepository tripRepository;

//    @BeforeEach
//   void setUp() {
//        passengerRepository.deleteAll();
//        routesRepository.deleteAll();
//        tripRepository.deleteAll();
//
//    }



    @Autowired
    BookingServiceImpl bookingService;

    @Autowired
    PassengerServiceImpl passengerService;



    @Test
    public void testThatAUserCanBookATrip(){
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFirstName("freddie");
        registrationRequest.setLastName("akewes");
        registrationRequest.setEmail("fareedtijani2810@gmail.com");
        registrationRequest.setPhone("08084563212225");
        registrationRequest.setPassword("freddieddhhhh");
        registrationRequest.setNextOfKinName("buharieegggggg");
        registrationRequest.setNextOfKinPhone("090993362622");
        registrationRequest.setGender("Male");
        RegistrationResponse response = passengerService.addPassenger(registrationRequest);
        BookARideRequest request = new BookARideRequest();
        request.setPassengerId(2L);

        request.setDestinationAdress("oyo, ibadan");
        request.setDepatureAddress("lagos yaba");
        request.setDepatureTime(LocalTime.of(6,0));
        request.setDepartureDate(LocalDate.of(2024,10,27));
        BookARideResponse response1 = bookingService.bookARide(request);
        assertThat(response1).isNotNull();
    }

}