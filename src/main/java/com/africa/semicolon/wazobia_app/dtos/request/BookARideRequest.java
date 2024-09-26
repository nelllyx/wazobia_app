package com.africa.semicolon.wazobia_app.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter

public class BookARideRequest {
    private Long passengerId;
    private String destinationAdress;
    private String depatureAddress;
    private LocalTime depatureTime;
    private LocalDate departureDate;

}
