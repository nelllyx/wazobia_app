package com.africa.semicolon.wazobia_app.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vehicles")

public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long driverId;
    private String plateNumber;
    private String make;
    private String model;
    private int numberOfSeat = 0;

}
