package com.africa.semicolon.wazobia_app.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
public class Trip {
    @Id
    private Long id;
    private String RouteId;
    private String VehiclesId;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
}
