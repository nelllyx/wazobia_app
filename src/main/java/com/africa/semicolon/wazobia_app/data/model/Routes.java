package com.africa.semicolon.wazobia_app.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@Entity


@Table(name = "routes")
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;
    private String departure;
    private Long passengerId;
    private LocalTime departureTime;
    private String destination;
    private LocalDate departureDate;



}
