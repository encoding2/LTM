package com.edutech.progressive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.edutech.progressive.dao.PatientDAO;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.impl.PatientServiceImplJdbc;

public class DayEightTest {

    @Test
    void testGetAllPatients() throws Exception {

        Patient patient = new Patient(
                101,
                "Arun Kumar",
                new Date(),
                "9876543210",
                "arun@gmail.com",
                "Chennai"
        );

        List<Patient> patients = new ArrayList<>();
        patients.add(patient);

        PatientDAO patientDAO = new PatientDAO() {

            @Override
            public List<Patient> getAllPatients() throws SQLException {
                return patients;
            }

            @Override
            public int addPatient(Patient patient) throws SQLException {
                return 101;
            }

            @Override
            public Patient getPatientById(int patientId) throws SQLException {
                return patient;
            }

            @Override
            public void updatePatient(Patient patient) throws SQLException {
            }

            @Override
            public void deletePatient(int patientId) throws SQLException {
            }
        };

        PatientServiceImplJdbc service =
                new PatientServiceImplJdbc(patientDAO);

        List<Patient> result = service.getAllPatients();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Arun Kumar", result.get(0).getFullName());
    }

    @Test
    void testAddPatient() throws Exception {

        Patient patient = new Patient(
                102,
                "Priya Sharma",
                new Date(),
                "9123456789",
                "priya@gmail.com",
                "Coimbatore"
        );

        PatientDAO patientDAO = new PatientDAO() {

            @Override
            public int addPatient(Patient patient) throws SQLException {
                return 102;
            }

            @Override
            public Patient getPatientById(int patientId) throws SQLException {
                return null;
            }

            @Override
            public void updatePatient(Patient patient) throws SQLException {
            }

            @Override
            public void deletePatient(int patientId) throws SQLException {
            }

            @Override
            public List<Patient> getAllPatients() throws SQLException {
                return List.of();
            }
        };

        PatientServiceImplJdbc service =
                new PatientServiceImplJdbc(patientDAO);

        Integer result = service.addPatient(patient);

        assertNotNull(result);
        assertEquals(102, result);
    }

    @Test
    void testGetPatientById() throws Exception {

        Patient patient = new Patient(
                103,
                "Rahul Kumar",
                new Date(),
                "9000000000",
                "rahul@gmail.com",
                "Madurai"
        );

        PatientDAO patientDAO = new PatientDAO() {

            @Override
            public Patient getPatientById(int patientId) throws SQLException {
                return patient;
            }

            @Override
            public int addPatient(Patient patient) throws SQLException {
                return 103;
            }

            @Override
            public void updatePatient(Patient patient) throws SQLException {
            }

            @Override
            public void deletePatient(int patientId) throws SQLException {
            }

            @Override
            public List<Patient> getAllPatients() throws SQLException {
                return List.of(patient);
            }
        };

        PatientServiceImplJdbc service =
                new PatientServiceImplJdbc(patientDAO);

        Patient result = service.getPatientById(103);

        assertNotNull(result);
        assertEquals(103, result.getPatientId());
        assertEquals("Rahul Kumar", result.getFullName());
        assertEquals("Madurai", result.getAddress());
    }

    @Test
    void testGetAllPatientSortedByName() throws Exception {

        Patient patient1 = new Patient(
                104,
                "Zara Khan",
                new Date(),
                "9876543210",
                "zara@gmail.com",
                "Chennai"
        );

        Patient patient2 = new Patient(
                105,
                "Arun Kumar",
                new Date(),
                "9123456789",
                "arun@gmail.com",
                "Coimbatore"
        );

        Patient patient3 = new Patient(
                106,
                "Manoj Kumar",
                new Date(),
                "9000000000",
                "manoj@gmail.com",
                "Madurai"
        );

        List<Patient> patients = new ArrayList<>();
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);

        PatientDAO patientDAO = new PatientDAO() {

            @Override
            public List<Patient> getAllPatients() throws SQLException {
                return patients;
            }

            @Override
            public int addPatient(Patient patient) throws SQLException {
                return patient.getPatientId();
            }

            @Override
            public Patient getPatientById(int patientId) throws SQLException {
                return null;
            }

            @Override
            public void updatePatient(Patient patient) throws SQLException {
            }

            @Override
            public void deletePatient(int patientId) throws SQLException {
            }
        };

        PatientServiceImplJdbc service =
                new PatientServiceImplJdbc(patientDAO);

        List<Patient> result =
                service.getAllPatientSortedByName();

        assertNotNull(result);
        assertEquals(3, result.size());

        assertEquals("Arun Kumar", result.get(0).getFullName());
        assertEquals("Manoj Kumar", result.get(1).getFullName());
        assertEquals("Zara Khan", result.get(2).getFullName());
    }
}