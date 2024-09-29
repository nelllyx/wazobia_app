package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.repository.AdminRepository;
import com.africa.semicolon.wazobia_app.data.repository.DriverRepository;
import com.africa.semicolon.wazobia_app.dtos.request.AddDriverRequest;
import com.africa.semicolon.wazobia_app.dtos.request.AddVehicleRequest;
import com.africa.semicolon.wazobia_app.dtos.request.MapDriverToVehicleRequest;
import com.africa.semicolon.wazobia_app.dtos.request.RegisterAdminRequest;
import com.africa.semicolon.wazobia_app.dtos.response.AddDriverResponse;
import com.africa.semicolon.wazobia_app.dtos.response.AddVehicleResponse;
import com.africa.semicolon.wazobia_app.dtos.response.AdminRegisterResponse;
import com.africa.semicolon.wazobia_app.dtos.response.MapDriverToVehicleResponse;
import com.africa.semicolon.wazobia_app.exceptions.EmailExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class AdminServiceImplementationTest {
    @Autowired
    private  AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;
    @Autowired
    private DriverRepository driverRepository;

//    @BeforeEach
//    void setUp() {
//        adminRepository.deleteAll();
//        driverRepository.deleteAll();
//
//    }

//    @Test
//   public void register_As_An_Admin() {
//        RegisterAdminRequest registerAdminRequest = new RegisterAdminRequest();
//        registerAdminRequest.setFirstName("toluwalase");
//        registerAdminRequest.setLastName("obaturn");
//        registerAdminRequest.setEmail("toluwalase@gmail.com");
//        registerAdminRequest.setPassword("123456");
//        registerAdminRequest.setPhoneNumber("08104375142");
//        AdminRegisterResponse response = adminService.register_As_An_Admin(registerAdminRequest);
//        response.setMessage("Admin registered successfully");
//        assertNotNull(response);
//        assertThat(response.getMessage()).isEqualTo("Admin registered successfully");
//    }
//    @Test
//    public void register_Admin_With_Empty_FirstName_Should_Throw_Exception() {
//        RegisterAdminRequest registerAdminRequest = new RegisterAdminRequest();
//        registerAdminRequest.setFirstName("");
//        registerAdminRequest.setLastName("oba");
//        registerAdminRequest.setEmail("oba@gmail.com");
//        registerAdminRequest.setPassword("123456");
//        registerAdminRequest.setPhoneNumber("08104375142");
//
//        Exception exception = assertThrows(EmailExistsException.class, () -> {
//            adminService.register_As_An_Admin(registerAdminRequest);
//        });
//
//        String expectedMessage = "First name cannot be empty";
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
//    @Test
//    public void register_Admin_With_Empty_LastName_Should_Throw_Exception() {
//        RegisterAdminRequest registerAdminRequest = new RegisterAdminRequest();
//        registerAdminRequest.setFirstName("toluwalase");
//        registerAdminRequest.setLastName("");
//        registerAdminRequest.setEmail("toluwalase@gmail.com");
//        registerAdminRequest.setPassword("123456");
//        registerAdminRequest.setPhoneNumber("08104375142");
//
//        Exception exception = assertThrows(EmailExistsException.class, () -> {
//            adminService.register_As_An_Admin(registerAdminRequest);
//        });
//
//        String expectedMessage = "Last name cannot be empty";
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }

    @Test
    public void testThatAdminCanAddADriverToDatabase() {
        AddDriverRequest request = new AddDriverRequest();
        request.setEmail("bellobodunrin2277@gmail.com");
        request.setAddress("8,ikoga rd, Badagry, lagos");
        request.setPhoneNumber("09033778829");
        request.setLicenseNumber("D3Y3YE3Y4Y3EYUV7");
        request.setUserName("Bello Bodunrin");
        AddDriverResponse response = adminService.addDriver(request);
        assertThat(response.getMessage()).isEqualTo("Driver added successfully");


    }

    @Test
    public void testThatAdminCanAddVehicleToDatabase() {
        AddVehicleRequest request = new AddVehicleRequest();
        request.setPlateNumber("SMK-282-GD");
        request.setModel("2012");
        request.setMake("Mazda");
        request.setNumberOfSeats(16);
        AddVehicleResponse addVehicleResponse = adminService.addVehicle(request);
        assertThat(addVehicleResponse.getMessage()).isEqualTo("Vehicle added successfully");
    }

    @Test
    public void testThatAdminCanConnectDriverToVehicle(){
        MapDriverToVehicleRequest request = new MapDriverToVehicleRequest();
        request.setVehicleId(4L);
        request.setDriverId(4L);
        MapDriverToVehicleResponse response = adminService.connectVehicleToDriver(request);
        assertThat(response.getMessage()).isEqualTo("Driver connected to vehicle successfully");
    }

}