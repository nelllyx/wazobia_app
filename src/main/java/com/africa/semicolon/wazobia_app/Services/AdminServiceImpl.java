package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.model.Admin;
import com.africa.semicolon.wazobia_app.data.model.Driver;
import com.africa.semicolon.wazobia_app.data.model.Vehicles;
import com.africa.semicolon.wazobia_app.data.repository.AdminRepository;
import com.africa.semicolon.wazobia_app.data.repository.DriverRepository;
import com.africa.semicolon.wazobia_app.data.repository.VehiclesRepository;
import com.africa.semicolon.wazobia_app.dtos.request.*;
import com.africa.semicolon.wazobia_app.dtos.response.*;
import com.africa.semicolon.wazobia_app.exceptions.DriverDoesNotExists;
import com.africa.semicolon.wazobia_app.exceptions.VehicleExistsException;
import com.africa.semicolon.wazobia_app.exceptions.EmailExistsException;
import com.africa.semicolon.wazobia_app.exceptions.WrongEmailFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import com.africa.semicolon.wazobia_app.dtos.request.LoginAdminRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegisterAdminRequest;
import com.africa.semicolon.wazobia_app.dtos.response.AdminRegisterResponse;
import com.africa.semicolon.wazobia_app.dtos.response.LoginAdminResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.africa.semicolon.wazobia_app.utils.Mapper.mapDriver;
import static com.africa.semicolon.wazobia_app.utils.Mapper.mapVehicle;

@Service
@RequiredArgsConstructor


public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final DriverRepository driverRepository;
    private final VehiclesRepository vehiclesRepository;


    @Override
    public AdminRegisterResponse register_As_An_Admin(RegisterAdminRequest registerAdminRequest) {

        Admin admin = new Admin();
        validateRegisterAdmin(registerAdminRequest, admin.getEmail());
        validateEmail(registerAdminRequest.getEmail());
        admin.setFirstName(registerAdminRequest.getFirstName());
        admin.setLastName(registerAdminRequest.getLastName());
        admin.setEmail(registerAdminRequest.getEmail());
        admin.setPassword(registerAdminRequest.getPassword());
        admin.setPhoneNumber(registerAdminRequest.getPhoneNumber());
        adminRepository.save(admin);

        AdminRegisterResponse response = new AdminRegisterResponse();
        response.setMessage("Admin registered successfully");
        return response;
    }

    @Override
    public LoginAdminResponse loginAdmin(LoginAdminRequest loginAdminRequest) {
      Admin admin = adminRepository.findByEmail(loginAdminRequest.getEmail());
      validateEmail(loginAdminRequest.getEmail());
      admin.setEmail(loginAdminRequest.getEmail());
      admin.setPassword(loginAdminRequest.getPassword());

      LoginAdminResponse response = new LoginAdminResponse();
      response.setMessage("Admin logged in successfully");
      return response;
    }

    @Override
    public AddDriverResponse addDriver(AddDriverRequest request) {
        validateDriverEmail(request.getEmail());
        Driver driver = mapDriver(request);
        driverRepository.save(driver);
        AddDriverResponse response = new AddDriverResponse();
        response.setMessage("Driver added successfully");
        return response;
    }

    private void validateDriverEmail(String email) {
        List<Driver> drivers = driverRepository.findAll();
        for(Driver driver : drivers) {
            if(driver.getEmail().equals(email)) {
                throw new EmailExistsException("Driver already exists");
            }
        }
    }

    @Override
    public AddVehicleResponse addVehicle(AddVehicleRequest request) {
   validateVehiclePlateNumber(request);
        Vehicles vehicle = mapVehicle(request);
        vehiclesRepository.save(vehicle);
        AddVehicleResponse response = new AddVehicleResponse();
        response.setMessage("Vehicle added successfully");
        return response;
    }

    @Override
    public MapDriverToVehicleResponse connectVehicleToDriver(MapDriverToVehicleRequest request) {
        Driver drivers = driverRepository.findDriverById(request.getDriverId());
        Vehicles vehicle = vehiclesRepository.findVehicleById(request.getVehicleId());
        drivers.setVehicleId(request.getVehicleId());
        vehicle.setDriverId(request.getDriverId());
        driverRepository.save(drivers);
        vehiclesRepository.save(vehicle);
        MapDriverToVehicleResponse response = new MapDriverToVehicleResponse();
        response.setMessage("Driver connected to vehicle successfully");
        return response;
    }

    private void validateVehiclePlateNumber(AddVehicleRequest request) {
        List<Vehicles> vehicles = vehiclesRepository.findAll();
        for(Vehicles vehicle : vehicles) {
            if(vehicle.getPlateNumber().equals(request.getPlateNumber())) {
                throw new VehicleExistsException("Vehicle already exists");
            }
        }
    }


    private void validateRegisterAdmin(RegisterAdminRequest registerAdmin, String email) {
        for (Admin admin : adminRepository.findAll()) {
            if (admin.getEmail().equals(email)) {
                throw new EmailExistsException("Admin already exists");
            }
        }
        validateEmail(email);
        if (registerAdmin.getFirstName() == null || registerAdmin.getFirstName().trim().isEmpty()) {
            throw new WrongEmailFormatException("First name cannot be empty. Please input first name.");
        }
        if (registerAdmin.getPassword() == null || registerAdmin.getPassword().trim().isEmpty()) {
            throw new EmailExistsException("Password cannot be empty. Please input password.");
        }
        if (registerAdmin.getLastName() == null || registerAdmin.getLastName().trim().isEmpty()) {
            throw new EmailExistsException("Last name cannot be empty. Please input last name.");
        }
       
    }

    private void validateEmail(String email) {
        if(!email.contains("@")){
            throw new EmailExistsException("Email address must contain @");
        }
        if(!email.contains(".")){
            throw new EmailExistsException("Email address must contain .  ");
        }
        if (email.contains(" ")) {
            throw new EmailExistsException("Email address must not be blank.");
        }

    }

}


