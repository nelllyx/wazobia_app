package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import com.africa.semicolon.wazobia_app.data.repository.PassengerRepository;
import com.africa.semicolon.wazobia_app.dtos.request.BookARideRequest;
import com.africa.semicolon.wazobia_app.dtos.request.LoginPassengerRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegistrationRequest;
import com.africa.semicolon.wazobia_app.dtos.response.BookARideResponse;
import com.africa.semicolon.wazobia_app.dtos.response.LoginPassengerResponse;
import com.africa.semicolon.wazobia_app.dtos.response.RegistrationResponse;
import com.africa.semicolon.wazobia_app.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.africa.semicolon.wazobia_app.utils.Mapper.mapPassenger;
import static com.africa.semicolon.wazobia_app.utils.SimpleHash.hash;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private  PassengerRepository passengerRepository;
    @Autowired
    private BookingServiceImpl bookingServiceImpl;

    @Override
    public RegistrationResponse addPassenger(RegistrationRequest register) {

        if(passengerRepository.existsByEmail(register.getEmail())) throw new EmailExistsException("Email  has already been uesd!!");
        if (passengerRepository.existsByPhone(register.getPhone())) throw new EmailExistsException("Phone number has already been uesd!!");

        else {
            Passenger request = mapPassenger(register);
            passengerRepository.save(request);
            sendEmail(request.getEmail(), request.getFirstName());
        }
        RegistrationResponse response = new RegistrationResponse();
        response.setMessage("Account created sucessfully");
        return response;
    }

    @Override
    public LoginPassengerResponse loginPassenger(LoginPassengerRequest request) {
        List<Passenger> passengers = passengerRepository.findAll();
        Long passengerId = 0l;
        for (Passenger passenger : passengers) {
            if (!passenger.getEmail().equals(request.getEmail()) && !passenger.getPassword().equals(request.getPassword())) {
                passengerId = passenger.getId();
                throw new EmailExistsException("invalid username or password");
            }
        }
        LoginPassengerResponse response = new LoginPassengerResponse();
        response.setMessage("Login successful");
        String token = hash(passengerId);
        response.setToken(token);
        return response;
    }

    @Override
    public BookARideResponse bookARide(BookARideRequest request2) {
        return bookingServiceImpl.bookARide(request2);
    }


    @Value("$(Wazobia)")
    private String fromEmailId;


//
        public void sendEmail(String userEmail, String name){
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

