package com.edutech.progressive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.entity.Patient;

public class DayTwoTest {

    @Test
    void testClinicConstructorAndGetters() {
        Clinic clinic = new Clinic(
                101,
                "City Care Clinic",
                "Chennai",
                501,
                "9876543210",
                2015
        );

        assertEquals(101, clinic.getClinicId());
        assertEquals("City Care Clinic", clinic.getClinicName());
        assertEquals("Chennai", clinic.getLocation());
        assertEquals(501, clinic.getDoctorId());
        assertEquals("9876543210", clinic.getContactNumber());
        assertEquals(2015, clinic.getEstablishedYear());
    }

    @Test
    void testClinicSettersAndGetters() {
        Clinic clinic = new Clinic();

        clinic.setClinicId(102);
        clinic.setClinicName("Apollo Clinic");
        clinic.setLocation("Coimbatore");
        clinic.setDoctorId(502);
        clinic.setContactNumber("9123456789");
        clinic.setEstablishedYear(2020);

        assertEquals(102, clinic.getClinicId());
        assertEquals("Apollo Clinic", clinic.getClinicName());
        assertEquals("Coimbatore", clinic.getLocation());
        assertEquals(502, clinic.getDoctorId());
        assertEquals("9123456789", clinic.getContactNumber());
        assertEquals(2020, clinic.getEstablishedYear());
    }

    @Test
    void testPatientConstructorAndGetters() {
        Date dateOfBirth = new Date(100, 5, 15);

        Patient patient = new Patient(
                201,
                "Ravi Kumar",
                dateOfBirth,
                "9876543210",
                "ravi@gmail.com",
                "Chennai"
        );

        assertEquals(201, patient.getPatientId());
        assertEquals("Ravi Kumar", patient.getFullName());
        assertEquals(dateOfBirth, patient.getDateOfBirth());
        assertEquals("9876543210", patient.getContactNumber());
        assertEquals("ravi@gmail.com", patient.getEmail());
        assertEquals("Chennai", patient.getAddress());
    }

    @Test
    void testPatientSettersAndGetters() {
        Patient patient = new Patient();

        Date dateOfBirth = new Date(95, 2, 20);

        patient.setPatientId(202);
        patient.setFullName("Priya Sharma");
        patient.setDateOfBirth(dateOfBirth);
        patient.setContactNumber("9123456789");
        patient.setEmail("priya@gmail.com");
        patient.setAddress("Bangalore");

        assertEquals(202, patient.getPatientId());
        assertEquals("Priya Sharma", patient.getFullName());
        assertEquals(dateOfBirth, patient.getDateOfBirth());
        assertEquals("9123456789", patient.getContactNumber());
        assertEquals("priya@gmail.com", patient.getEmail());
        assertEquals("Bangalore", patient.getAddress());
    }
}