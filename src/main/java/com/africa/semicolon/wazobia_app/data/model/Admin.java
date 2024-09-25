package com.africa.semicolon.wazobia_app.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
