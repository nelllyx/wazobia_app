package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.model.Admin;
import com.africa.semicolon.wazobia_app.data.model.Vehicles;
import com.africa.semicolon.wazobia_app.data.repository.AdminRepository;
import com.africa.semicolon.wazobia_app.data.repository.VehiclesRepository;
import com.africa.semicolon.wazobia_app.dtos.request.LoginAdminRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegisterAdminRequest;
import com.africa.semicolon.wazobia_app.dtos.response.AdminRegisterResponse;
import com.africa.semicolon.wazobia_app.dtos.response.LoginAdminResponse;
import com.africa.semicolon.wazobia_app.exceptions.WazobiaException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;


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



    private void validateRegisterAdmin(RegisterAdminRequest registerAdmin, String email) {
        for (Admin admin : adminRepository.findAll()) {
            if (admin.getEmail().equals(email)) {
                throw new WazobiaException("Admin already exists");
            }
        }
        validateEmail(email);
        if (registerAdmin.getFirstName() == null || registerAdmin.getFirstName().trim().isEmpty()) {
            throw new WazobiaException("First name cannot be empty. Please input first name.");
        }
        if (registerAdmin.getPassword() == null || registerAdmin.getPassword().trim().isEmpty()) {
            throw new WazobiaException("Password cannot be empty. Please input password.");
        }
        if (registerAdmin.getLastName() == null || registerAdmin.getLastName().trim().isEmpty()) {
            throw new WazobiaException("Last name cannot be empty. Please input last name.");
        }
       
    }

    private void validateEmail(String email) {
        if(!email.contains("@")){
            throw new WazobiaException("Email address must contain @");
        }
        if(!email.contains(".")){
            throw new WazobiaException("Email address must contain .  ");
        }
        if (email.contains(" ")) {
            throw new WazobiaException("Email address must not be blank.");
        }

    }

}


