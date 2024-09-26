package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.model.Admin;
import com.africa.semicolon.wazobia_app.data.repository.AdminRepository;
import com.africa.semicolon.wazobia_app.dtos.request.RegisterAdminRequest;
import com.africa.semicolon.wazobia_app.dtos.response.AdminRegisterResponse;
import com.africa.semicolon.wazobia_app.exceptions.WazobiaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImplementation implements AdminService {
    @Autowired
    private  AdminRepository adminRepository;



    @Override
    public AdminRegisterResponse register_As_An_Admin(RegisterAdminRequest registerAdminRequest) {

            validateRegisterAdmin(registerAdminRequest);

        validateAdmin(registerAdminRequest);

        Admin admin = new Admin();
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

    private void validateRegisterAdmin(RegisterAdminRequest registerAdmin) {
        if (registerAdmin.getFirstName() == null || registerAdmin.getFirstName().trim().isEmpty()) {
            throw new WazobiaException("First name cannot be empty. Please input first name.");
        }
        if (registerAdmin.getPassword() == null || registerAdmin.getPassword().trim().isEmpty()) {
            throw new WazobiaException("Password cannot be empty. Please input password.");
        }
        if (registerAdmin.getEmail() == null || registerAdmin.getEmail().trim().isEmpty()) {
            throw new WazobiaException("Email cannot be empty. Please input email.");
        }
        if (registerAdmin.getLastName() == null || registerAdmin.getLastName().trim().isEmpty()) {
            throw new WazobiaException("Last name cannot be empty. Please input last name.");
        }
       if(registerAdmin.getPassword().length()<6){
           throw new WazobiaException("Password must be at least 6 characters long");
       }
       if(!registerAdmin.getEmail().matches(".*@")){
           throw new WazobiaException("Email is not valid pls input the correct email with @ annotation.");

       }
       if(registerAdmin.getPhoneNumber() == null || registerAdmin.getPhoneNumber().trim().isEmpty()) {
           throw new WazobiaException("Phone number cannot be empty. Please input phone number.");
       }
       if(!registerAdmin.getPhoneNumber().matches("//d+")){
           throw new WazobiaException("phone number must be a positive number.");
       }
       if(!registerAdmin.getPhoneNumber().matches("^\\d{11}$") ){
           throw new WazobiaException("phone number must be exactly 11 digits long");
       }
    }
    private void validateAdmin(RegisterAdminRequest registerAdmin) {
        for(Admin admin: adminRepository.findAll()){
            if(admin.getEmail().equals(registerAdmin.getEmail())){
                throw new WazobiaException("Email already in use. Please choose another one.");

            }
        }
        for(Admin admin: adminRepository.findAll()){
            if(admin.getPassword().equals(registerAdmin.getPassword())){
                throw new WazobiaException("Password already in use. Please choose another one.");
            }
        }
        for(Admin admin: adminRepository.findAll()){
            if(admin.getPhoneNumber().equals(registerAdmin.getPhoneNumber())){
                throw new WazobiaException("Phone number already exist. Please choose another one.");
            }

        }
        for(Admin admin: adminRepository.findAll()){
            if(admin.getFirstName().equals(registerAdmin.getFirstName())){
                throw new WazobiaException("First name already exist. Please choose another one.");
            }

        }
        for(Admin admin: adminRepository.findAll()){
            if(admin.getLastName().equals(registerAdmin.getLastName())){
                throw new WazobiaException("Last name already exist. Please choose another one.");
            }
        }

    }
}


