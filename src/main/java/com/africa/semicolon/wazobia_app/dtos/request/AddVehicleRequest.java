package com.africa.semicolon.wazobia_app.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddVehicleRequest {
    private String plateNumber;
    private String make;
    private String model;
    private int numberOfSeats = 0;
}
