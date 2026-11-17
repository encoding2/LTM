package com.edutech.progressive;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.edutech.progressive.controller.UserLoginController;
import com.edutech.progressive.dto.LoginRequest;
import com.edutech.progressive.dto.LoginResponse;
import com.edutech.progressive.dto.UserRegistrationDTO;
import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.entity.User;
import com.edutech.progressive.jwt.JwtUtil;
import com.edutech.progressive.repository.*;
import com.edutech.progressive.service.impl.UserLoginServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DayTwentyTest {
    @Mock
    private UserLoginServiceImpl userLoginService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserLoginController userLoginController;

    @InjectMocks
    private UserLoginServiceImpl userLoginServiceImpl;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private final String secret = "secretKey000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

    @BeforeEach
    void setup() {
        appointmentRepository.deleteAll();
        billingRepository.deleteAll();
        clinicRepository.deleteAll();
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM user");
            statement.executeUpdate("DELETE FROM patient");
            statement.executeUpdate("DELETE FROM doctor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Patient getPatientObject(Integer id, String patientName) throws ParseException {
        Patient patient = new Patient();
        if (id != null) {
            patient.setPatientId(id);
        }
        patient.setFullName(patientName);
        patient.setContactNumber("9876543210");
        patient.setEmail("mary@gmail.com");
        patient.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1985-06-15"));
        return patient;
    }

    Doctor getDoctorObject(Integer id, String name, int experience) {
        Doctor doctor = new Doctor();
        if (id != null) {
            doctor.setDoctorId(id);
        }
        doctor.setFullName(name);
        doctor.setContactNumber("9876543210");
        doctor.setEmail("john@gmail.com");
        doctor.setSpecialty("Orthopedic");
        doctor.setYearsOfExperience(experience);
        return doctor;
    }

    Clinic getClinicObject(Integer id, Doctor doctor, String name) {
        Clinic clinic = new Clinic();
        if (id != null) {
            clinic.setClinicId(id);
        }
        setDynamicProperty(clinic, "doctor", doctor);
        clinic.setLocation("Austin");
        clinic.setClinicName(name);
        clinic.setContactNumber("9876543210");
        clinic.setEstablishedYear(2020);
        return clinic;
    }

    public void setDynamicProperty(Object entity, String propertyName, Object value) {
        try {
            Field field = entity.getClass().getDeclaredField(propertyName);
            field.setAccessible(true);
            field.set(entity, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Day20 Testcases:-
    @Test
    void testRegisterUser_Failure_Day20() throws Exception {
        UserRegistrationDTO dto = new UserRegistrationDTO();
        dto.setUsername("testuser");
        dto.setPassword("password");
        dto.setRole("INVALID_ROLE");

        doThrow(new RuntimeException("Invalid role. Only 'PATIENT' or 'DOCTOR' allowed.")).when(userLoginService).registerUser(dto);

        ResponseEntity<?> response = userLoginController.registerUser(dto);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Invalid role. Only 'PATIENT' or 'DOCTOR' allowed.", response.getBody());
    }

    @Test
    void testLoginUser_Success_Day20() throws ParseException {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testUser");
        loginRequest.setPassword("password");

        UserDetails userDetails = mock(UserDetails.class);

        Patient patient = getPatientObject(1, "John");
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("Password@123");
        user.setUserId(1);
        user.setRole("PATIENT");
        user.setPatient(patient);

        when(userRepository.findByUsername("testUser")).thenReturn(user);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(null);
        when(userLoginService.loadUserByUsername("testUser")).thenReturn(userDetails);
        when(userLoginService.getUserByUsername("testUser")).thenReturn(user);
        when(jwtUtil.generateToken("testUser")).thenReturn("mockToken");

        ResponseEntity<LoginResponse> response = userLoginController.loginUser(loginRequest);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("mockToken", response.getBody().getToken());
        assertEquals(1, response.getBody().getUserId());
    }

    @Test
    void testGetUserDetails_Success_Day20() {
        User user = new User();
        user.setUserId(123);
        user.setUsername("meaningfulTestUser");

        when(userLoginService.getUserDetails(123)).thenReturn(user);

        ResponseEntity<?> response = userLoginController.getUserDetails(123);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());

        when(userRepository.findById(123)).thenReturn(Optional.of(user));

        User result = userLoginServiceImpl.getUserDetails(123);
        assertEquals(123, result.getUserId());
    }

    @Test
    void testGetUserDetails_UserNotFound_Day20() {
        when(userLoginService.getUserDetails(123)).thenThrow(new RuntimeException("User not found with ID: 123"));

        ResponseEntity<?> response = userLoginController.getUserDetails(123);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("User not found with ID: 123", response.getBody());

        when(userRepository.findById(123)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> userLoginServiceImpl.getUserDetails(123));
        assertEquals("User not found with ID: 123", exception.getMessage());
    }
}
