package com.africa.semicolon.wazobia_app.data.model;


<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
=======


import jakarta.persistence.*;


>>>>>>> 119def295519f485f24431dc63559987402a1547
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
<<<<<<< HEAD
@Entity
=======

@Table(name = "routes")
>>>>>>> 119def295519f485f24431dc63559987402a1547
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;
    private String departure;
<<<<<<< HEAD
    private Long passengerId;
    private LocalTime departureTime;
    private String destination;
=======
    private String destination;
    private LocalTime departureTime;
>>>>>>> 119def295519f485f24431dc63559987402a1547
    private LocalDate departureDate;
    private Long passengerId;


}
