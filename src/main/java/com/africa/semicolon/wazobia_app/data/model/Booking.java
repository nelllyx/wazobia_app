package com.africa.semicolon.wazobia_app.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Long passengerId;
    private Long tripId;
    private LocalDate bookingDate;
    private String bookingStatus;
    private String paymentMethod;
    private String paymentStatus;
    private double totalCost;

}



