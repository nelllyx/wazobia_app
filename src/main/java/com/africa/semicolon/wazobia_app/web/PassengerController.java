package com.africa.semicolon.wazobia_app.web;

import com.africa.semicolon.wazobia_app.Services.PassengerService;
import com.africa.semicolon.wazobia_app.dtos.request.LoginPassengerRequest;
import com.africa.semicolon.wazobia_app.dtos.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/passenger")
@CrossOrigin
@Controller
public class PassengerController {
    @Autowired
    private PassengerService passengerService;
    @GetMapping("/login-passenger")
    public ResponseEntity<?> loginPassenger(@RequestBody LoginPassengerRequest request) {
        try{
            LoginResponse response = passengerService.loginPassenger(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
