package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.repository.PassengerRepository;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.exceptions.EmailExistsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@SpringBootTest
class PassengerServiceImplTest {
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private PassengerRepository passengerRepository;

    @Test
    void testThatPassengerCanSignUp(){
        RegistrationRequest request = new RegistrationRequest();
        request.setFirstName("firstName");
        request.setLastName("lastName");
        request.setEmail("fareedtijani2810@gmail.com");
        request.setPassword("password");
        request.setGender("male");
        request.setPhone("090");
        request.setNextOfKinName("fareed");
        request.setNextOfKinPhone("232");
        //request.setUserId(1L);
        passengerService.addPassenger(request);
        assertThrows(EmailExistsException.class, ()-> passengerService.addPassenger(request));

    }

}