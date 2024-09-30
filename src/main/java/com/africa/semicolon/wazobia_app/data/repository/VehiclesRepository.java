package com.africa.semicolon.wazobia_app.data.repository;

import com.africa.semicolon.wazobia_app.data.model.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiclesRepository extends JpaRepository<Vehicles ,Long> {
    Vehicles findVehicleById(Long vehicleId);
}
