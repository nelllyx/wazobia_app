package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.dtos.request.*;
import com.africa.semicolon.wazobia_app.dtos.response.*;

public interface AdminService {
    AdminRegisterResponse register_As_An_Admin (RegisterAdminRequest registerAdminRequest);
    LoginAdminResponse loginAdmin (LoginAdminRequest loginAdminRequest);
    AddDriverResponse addDriver(AddDriverRequest request);
    AddVehicleResponse addVehicle(AddVehicleRequest request);
    MapDriverToVehicleResponse connectVehicleToDriver(MapDriverToVehicleRequest request);
}
