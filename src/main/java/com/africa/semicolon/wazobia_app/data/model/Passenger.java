package com.africa.semicolon.wazobia_app.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String nextOfKinName;
    private String nextOfKinPhone;

}
