package com.africa.semicolon.wazobia_app.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
    private Long driverId;
=======
    private String driverId;
>>>>>>> 119def295519f485f24431dc63559987402a1547
    private String plateNumber;
    private String make;
    private String model;
    private int numberOfSeat;

}
