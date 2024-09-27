package com.africa.semicolon.wazobia_app.data.model;




import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter

@Table(name = "routes")
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;
    private String departure;
    private String destination;
    private LocalTime departureTime;
    private LocalDate departureDate;
    private Long passengerId;


}
