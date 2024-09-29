package com.africa.semicolon.wazobia_app.web;
import com.africa.semicolon.wazobia_app.Services.PassengerService;

import com.africa.semicolon.wazobia_app.data.model.Passenger;

import com.africa.semicolon.wazobia_app.dtos.request.LoginPassengerRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.ApiResponse;
import com.africa.semicolon.wazobia_app.dtos.response.LoginPassengerResponse;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("/passenger")
@CrossOrigin(origins = "*")
public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping("sign-up")
    public ResponseEntity<?> userRegistration(@RequestBody RegistrationRequest request) {
        try{
            RegistrationResponse response = passengerService.addPassenger(request);
            return new ResponseEntity<>(new ApiResponse(true,response), CREATED);
        }catch (RuntimeException exception){
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()), BAD_REQUEST);

        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> userRegistration(@RequestBody LoginPassengerRequest request){
        try{
            LoginPassengerResponse response = passengerService.loginPassenger(request);
            return new ResponseEntity<>(new ApiResponse(true,response), CREATED);
        }catch (RuntimeException exception){
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()), BAD_REQUEST);
        }
    }

}
