package com.edutech.progressive;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.repository.ClinicRepository;
import com.edutech.progressive.repository.DoctorRepository;
import com.edutech.progressive.repository.PatientRepository;
import com.edutech.progressive.service.ClinicService;
import com.edutech.progressive.service.DoctorService;
import com.edutech.progressive.service.PatientService;
import com.edutech.progressive.service.impl.ClinicServiceImplJpa;
import com.edutech.progressive.service.impl.DoctorServiceImplJpa;
import com.edutech.progressive.service.impl.PatientServiceImplJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MediConnectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DayThirteenTest {

   private ObjectMapper objectMapper;

   @Autowired
   ClinicRepository clinicRepository;
   @Autowired
   DoctorRepository doctorRepository;
   @Autowired
   PatientRepository patientRepository;

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private WebApplicationContext webApplicationContext;

   @BeforeEach
   public void setUp() {
       objectMapper = new ObjectMapper();
       mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
       String url = "jdbc:mysql://localhost:3306/mydb";
       String user = "root";
       String password = "root";
       try (Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement()) {
           String deleteQuery = "DELETE FROM clinic";
           statement.executeUpdate(deleteQuery);

           deleteQuery = "DELETE FROM patient";
           statement.executeUpdate(deleteQuery);

           deleteQuery = "DELETE FROM doctor";
           statement.executeUpdate(deleteQuery);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       MockitoAnnotations.openMocks(this);
   }

   // Helper classes to create Objects
   Doctor getDoctorObject(Integer id, String name, int experience) {
       Doctor doctor = new Doctor();
       if (id != null) {
           doctor.setDoctorId(id.intValue());
       }
       doctor.setFullName(name);
       doctor.setContactNumber("9876543210");
       doctor.setEmail("john@gmail.com");
       doctor.setSpecialty("Orthopedic");
       doctor.setYearsOfExperience(experience);
       return doctor;
   }

   Patient getPatientObject(Integer id, String patientName) throws ParseException {
       Patient patient = new Patient();
       if (id != null) {
           patient.setPatientId(id.intValue());
       }
       patient.setFullName(patientName);
       patient.setContactNumber("9876543210");
       patient.setEmail("mary@gmail.com");
       patient.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1985-06-15"));
       return patient;
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
           // Handle exception
       }
   }

   // Day - 13 Test cases

   @Test
   void testGetAllPatient_Day13() throws Exception {
       PatientService patientService = new PatientServiceImplJpa(patientRepository);
       Patient patients1 = getPatientObject(null, "Dhoni");
       Patient patients2 = getPatientObject(null, "Virat");
       patientService.addPatient(patients1);
       patientService.addPatient(patients2);

       List<Patient> result = patientService.getAllPatients();

       assertNotNull(result);
       assertEquals(2, result.size());
   }

   @Test
   void testGetAllPatientsSortedByName_Day13() throws Exception {
       PatientService patientService = new PatientServiceImplJpa(patientRepository);
       Patient patients1 = getPatientObject(null, "Dhoni");
       Patient patients2 = getPatientObject(null, "Virat");
       Patient patients3 = getPatientObject(null, "Warner");
       patientService.addPatient(patients1);
       patientService.addPatient(patients2);
       patientService.addPatient(patients3);

       List<Patient> sortedPatient = patientService.getAllPatientSortedByName();

       assertEquals(sortedPatient.get(0).getFullName(), patients1.getFullName());
   }

   @Test
   void testUpdatePatientController_Day13() throws Exception {
       PatientService patientService = new PatientServiceImplJpa(patientRepository);
       Patient patients1 = getPatientObject(null, "Dhoni");
       int patientId = patientService.addPatient(patients1);
       patients1.setPatientId(patientId);

       patients1.setFullName("Smith");
       mockMvc.perform(put("/patient/" + patientId)
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(objectMapper.writeValueAsString(patients1)))
               .andExpect(status().isOk());
       Patient updatedPatient = patientService.getPatientById(patientId);
       assertEquals("Smith", updatedPatient.getFullName());
   }

   @Test
   void testDeletePatientController_Day13() throws Exception {
       PatientService patientService = new PatientServiceImplJpa(patientRepository);

       Patient patients1 = getPatientObject(null, "Dhoni");
       int patientId = patientService.addPatient(patients1);

       mockMvc.perform(delete("/patient/" + patientId).contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isNoContent());
       assertNull(patientService.getPatientById(patientId));
   }

  
}
