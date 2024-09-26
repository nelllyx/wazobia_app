package com.africa.semicolon.wazobia_app.data.repository;

import com.africa.semicolon.wazobia_app.data.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByEmail(String email);

}
