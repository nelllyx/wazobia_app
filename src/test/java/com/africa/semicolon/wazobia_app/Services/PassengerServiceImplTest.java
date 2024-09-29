package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.repository.PassengerRepository;
import com.africa.semicolon.wazobia_app.data.repository.RoutesRepository;
import com.africa.semicolon.wazobia_app.data.repository.TripRepository;
import com.africa.semicolon.wazobia_app.dtos.request.BookARideRequest;
import com.africa.semicolon.wazobia_app.dtos.request.LoginPassengerRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.BookARideResponse;
import com.africa.semicolon.wazobia_app.dtos.response.LoginPassengerResponse;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;
import com.africa.semicolon.wazobia_app.exceptions.EmailExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.africa.semicolon.wazobia_app.utils.SimpleHash.decrypt;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@SpringBootTest
class PassengerServiceImplTest {
    @Autowired
    private PassengerService passengerService;
    @Autowired
    public  PassengerRepository passengerRepository;
    @Autowired
    public RoutesRepository routesRepository;
    @Autowired
    public TripRepository tripRepository;

    @BeforeEach
    void setUp() {
        passengerRepository.deleteAll();
        routesRepository.deleteAll();
        tripRepository.deleteAll();

    }

    @Test
    void testThatPassengerCanSignUp(){
       RegistrationRequest request = createPassenger();
        RegistrationResponse response = passengerService.addPassenger(request);
//        assertThrows(EmailExistsException.class, ()-> passengerService.addPassenger(request));
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Account created sucessfully");

    }

    public RegistrationRequest createPassenger(){
        RegistrationRequest request = new RegistrationRequest();
        request.setFirstName("firstName");
        request.setLastName("lastName");
        request.setEmail("fareedtijani2810@gmail.com");
        request.setPassword("password");
        request.setGender("male");
        request.setPhone("090999");
        request.setNextOfKinName("fareed");
        request.setNextOfKinPhone("232");
        return request;
    }

    @Test
    void testThatIfPassengerSignupWithSameEmail_ThrowsException(){
        RegistrationRequest request = new RegistrationRequest();
        request.setFirstName("firstName");
        request.setLastName("lastName");
        request.setEmail("fareedtijani281800@gmail.com");
        request.setPassword("password");
        request.setGender("male");
        request.setPhone("090999");
        request.setNextOfKinName("fareed");
        request.setNextOfKinPhone("232");
        RegistrationRequest request1 = createPassenger();
        passengerService.addPassenger(request);
        assertThrows(EmailExistsException.class, ()->passengerService.addPassenger(request1));
    }

    @Test
    void testThatIfPassengerSignUpWithSamePhoneNumber_ThrowsException(){
        RegistrationRequest request = new RegistrationRequest();
        request.setFirstName("firstName");
        request.setLastName("lastName");
        request.setEmail("fareedtijani281800@gmail.com");
        request.setPassword("password");
        request.setGender("male");
        request.setPhone("090999");
        request.setNextOfKinName("fareed");
        request.setNextOfKinPhone("232");
        RegistrationRequest request1 = createPassenger();
        passengerService.addPassenger(request);
        assertThrows(EmailExistsException.class, ()->passengerService.addPassenger(request1));
    }

    @Test
    public void test_thatPassengerCanLogin(){
        RegistrationRequest request = createPassenger();
        LoginPassengerRequest request1 = new LoginPassengerRequest();
        request.setEmail("fareedtijani2810gmail.com");
        request1.setPassword("password");
        LoginPassengerResponse response = passengerService.loginPassenger(request1);
        assertThat(response).isNotNull();
        assertThat(response.getToken()).isEqualTo("rfbaaaaaaa");

    }

    @Test
    public void test_thatPassengerCanBookAtrip(){
        RegistrationRequest request = createPassenger();
        RegistrationResponse response2 = passengerService.addPassenger(request);
        LoginPassengerRequest request1 = new LoginPassengerRequest();
        request.setEmail("fareedtijani2810gmail.com");
        request1.setPassword("password");
        LoginPassengerResponse response = passengerService.loginPassenger(request1);
        BookARideRequest request2 = new BookARideRequest();
        request2.setPassengerId(response.getToken());
        request2.setDepartureTime(LocalTime.of(6, 30));
        request2.setDepartureAddress("sabo yaba");
        request2.setDepartureDate(LocalDate.of(2024,9,20));
        request2.setDestinationAddress("lekki sama");
        BookARideResponse response1 = passengerService.bookARide(request2);
        assertThat(response1).isNotNull();
        String info = """
        Booking successful!
        Your trip from sabo yaba to lekki sama has been confirmed for 2024-09-20 at 06:30
        Head to the Payment Page to Make Payment And Get More
        Infomation About your trip
        """;
        assertThat(response1.getBookingInfo()).isEqualTo(info);
    }

}