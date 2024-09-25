package com.africa.semicolon.wazobia_app.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehicles {
    @Id
    private Long id;
    private String plateNumber;
    private String make;
    private String model;
    private int numberOfSits;

}
