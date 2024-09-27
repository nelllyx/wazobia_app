package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.data.repository.AdminRepository;
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

    @BeforeEach
    void setUp() {
        adminRepository.deleteAll();

    }

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
        request.setEmail("werey@gmails.coms");
        request.setAddress("Abule egbas");
        request.setPhoneNumber("0904532513");
        request.setLicenseNumber("1223345333445356989");
        request.setUserName("Buhari Obiss");
        AddDriverResponse response = adminService.addDriver(request);
        assertThat(response.getMessage()).isEqualTo("Driver added successfully");


    }

    @Test
    public void testThatAdminCanAddVehicleToDatabase() {
        AddVehicleRequest request = new AddVehicleRequest();
        request.setPlateNumber("OSU54-35");
        request.setModel("BMW");
        request.setMake("Toyota");
        request.setNumberOfSeats(16);
        AddVehicleResponse addVehicleResponse = adminService.addVehicle(request);
        assertThat(addVehicleResponse.getMessage()).isEqualTo("Vehicle added successfully");
    }

    @Test
    public void testThatAdminCanConnectDriverToVehicle(){
        MapDriverToVehicleRequest request = new MapDriverToVehicleRequest();
        request.setPlateNumber("OSU54-35");
        request.setDriverId(1L);
        MapDriverToVehicleResponse response = adminService.connectVehicleToDriver(request);
        assertThat(response.getMessage()).isEqualTo("Driver connected to vehicle successfully");
    }

}