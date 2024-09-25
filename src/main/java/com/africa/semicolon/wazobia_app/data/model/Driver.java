package com.africa.semicolon.wazobia_app.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Driver {
    @Id
    private Long id;
    private String driverName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String licenseNumber;
}
