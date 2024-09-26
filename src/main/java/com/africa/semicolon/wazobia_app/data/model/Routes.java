package com.africa.semicolon.wazobia_app.data.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;
    private Long passengerId;
    private String startingPoint;
    private LocalTime depatureTime;
    private String endingPoint;
    private LocalDate departureDate;

}
