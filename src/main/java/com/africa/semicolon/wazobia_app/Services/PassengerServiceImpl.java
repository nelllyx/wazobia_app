package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import com.africa.semicolon.wazobia_app.data.repository.PassengerRepository;
import com.africa.semicolon.wazobia_app.dtos.request.LoginPassengerRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.LoginResponse;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;

import com.africa.semicolon.wazobia_app.exceptions.EmailExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.africa.semicolon.wazobia_app.exceptions.WazobiaException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import static com.africa.semicolon.wazobia_app.utils.Mapper.mapPassenger;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final JavaMailSender mailSender;

    private final PassengerRepository passengerRepository;
    @Override
    public RegistrationResponse addPassenger(RegistrationRequest register) {
        Passenger request = mapPassenger(register);

        if(passengerRepository.existsByEmail(request.getEmail())|| passengerRepository.existsByPhone(request.getPhone())) {
            throw new WazobiaException("User already exists");
        }else {
            passengerRepository.save(request);
            sendEmail(request.getEmail(), request.getFirstName());
        }
        RegistrationResponse response = new RegistrationResponse();
        response.setMessage("You have successfully added passenger");
        return response;
    }


    @Value("$(Wazobia)")
    private String fromEmailId;
    public void sendEmail(String userEmail, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmailId);
        message.setTo(userEmail);
        message.setSubject("Wazobia Account Verification");
        message.setText(String.format("""
                Hi %s,
                
                Welcome to Wazobia! We’re thrilled to have you join our transportation management system. You’re now set up with your Gmail account %s.
                
                Click here to log in to your account:
                -> Log in to your account: [Login Link]
                
                Our goal is to help you manage transportation efficiently. If you have any questions, contact us anytime at wazobiateam2024@gmail.com.
                
                We look forward to supporting your transportation needs!
                
                Best, \s
                The Wazobia Team""",name,userEmail));
        mailSender.send(message);

    }


    }






