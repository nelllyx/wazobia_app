package com.africa.semicolon.wazobia_app.data.repository;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phoneNumber);
    Passenger findPassengerById(Long id);


    //Passenger findByFirstNameAndLastName(String firstName, String lastName);
}
