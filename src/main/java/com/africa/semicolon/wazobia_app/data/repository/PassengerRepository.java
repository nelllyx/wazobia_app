package com.africa.semicolon.wazobia_app.data.repository;

import com.africa.semicolon.wazobia_app.data.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
