package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.dtos.request.RegisterAdminRequest;
import com.africa.semicolon.wazobia_app.dtos.response.AdminRegisterResponse;

public interface AdminService {
    AdminRegisterResponse register_As_An_Admin (RegisterAdminRequest registerAdminRequest);
}
