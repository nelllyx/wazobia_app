package com.africa.semicolon.wazobia_app.web;

import com.africa.semicolon.wazobia_app.Services.AdminService;
import com.africa.semicolon.wazobia_app.dtos.request.RegisterAdminRequest;
import com.africa.semicolon.wazobia_app.dtos.response.AdminRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/registerAsAnAdmin")
    public ResponseEntity<?> registerAsAnAdmin(@RequestBody RegisterAdminRequest registerAdminRequest) {
        try {
            AdminRegisterResponse response = adminService.register_As_An_Admin(registerAdminRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
