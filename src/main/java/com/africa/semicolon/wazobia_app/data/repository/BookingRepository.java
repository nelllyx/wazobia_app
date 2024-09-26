package com.africa.semicolon.wazobia_app.data.repository;

import com.africa.semicolon.wazobia_app.data.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
