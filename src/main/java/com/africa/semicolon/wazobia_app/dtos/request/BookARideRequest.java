package com.africa.semicolon.wazobia_app.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter

public class BookARideRequest {
    private String passengerId;
    private String destinationAddress;
    private String departureAddress;
    private LocalTime departureTime;
    private LocalDate departureDate;

}
