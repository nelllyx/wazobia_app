package com.africa.semicolon.wazobia_app.web;
import com.africa.semicolon.wazobia_app.Services.PassengerService;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/passenger")
public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping("sign-up")
    public ResponseEntity<?> userRegistration(@RequestBody RegistrationRequest request) {
        try{
            RegistrationResponse response = passengerService.addPassenger(request);
            return ResponseEntity.ok(response);
        }catch (Exception message){
            return ResponseEntity.badRequest().body(message);
        }
    }

}
