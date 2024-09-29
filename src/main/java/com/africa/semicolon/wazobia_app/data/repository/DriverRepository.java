package com.africa.semicolon.wazobia_app.data.repository;

import com.africa.semicolon.wazobia_app.data.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver , Long> {
    Driver findDriverById(Long driverId);

}
