package com.africa.semicolon.wazobia_app.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapDriverToVehicleRequest {
    private Long driverId;
    private Long vehicleId;
}
