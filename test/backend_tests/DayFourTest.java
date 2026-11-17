package com.edutech.progressive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.edutech.progressive.dao.ClinicDAO;
import com.edutech.progressive.dao.DoctorDAO;
import com.edutech.progressive.dao.PatientDAO;
import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.impl.ClinicServiceImplJdbc;
import com.edutech.progressive.service.impl.DoctorServiceImplJdbc;
import com.edutech.progressive.service.impl.PatientServiceImplJdbc;

public class DayFourTest {

    @Test
    void testClinicServiceDelegatesGetAllClinicsToDAO() {

        Clinic clinic = new Clinic(
                101,
                "City Care Clinic",
                "Chennai",
                501,
                "9876543210",
                2015
        );

        List<Clinic> clinics = new ArrayList<>();
        clinics.add(clinic);

        ClinicDAO clinicDAO = new ClinicDAO() {

            @Override
            public int addClinic(Clinic clinic) {
                return 101;
            }

            @Override
            public Clinic getClinicById(int clinicId) {
                return clinic;
            }

            @Override
            public void updateClinic(Clinic clinic) {
            }

            @Override
            public void deleteClinic(int clinicId) {
            }

            @Override
            public List<Clinic> getAllClinics() {
                return clinics;
            }
        };

        ClinicServiceImplJdbc service =
                new ClinicServiceImplJdbc(clinicDAO);

        List<Clinic> result = service.getAllClinics();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("City Care Clinic", result.get(0).getClinicName());
    }

    @Test
    void testDoctorServiceDelegatesGetDoctorByIdToDAO() {

        Doctor doctor = new Doctor(
                201,
                "Dr. Arun Kumar",
                "Cardiology",
                "9876543210",
                "arun@gmail.com",
                12
        );

        DoctorDAO doctorDAO = new DoctorDAO() {

            @Override
            public int addDoctor(Doctor doctor) {
                return 201;
            }

            @Override
            public Doctor getDoctorById(int doctorId) {
                return doctor;
            }

            @Override
            public void updateDoctor(Doctor doctor) {
            }

            @Override
            public void deleteDoctor(int doctorId) {
            }

            @Override
            public List<Doctor> getAllDoctors() {
                return List.of(doctor);
            }
        };

        DoctorServiceImplJdbc service =
                new DoctorServiceImplJdbc(doctorDAO);

        Doctor result = service.getDoctorById(201);

        assertNotNull(result);
        assertEquals(201, result.getDoctorId());
        assertEquals("Dr. Arun Kumar", result.getFullName());
        assertEquals(12, result.getYearsOfExperience());
    }

    @Test
    void testPatientServiceDelegatesGetPatientByIdToDAO() {

        Patient patient = new Patient(
                301,
                "Ravi Kumar",
                new java.util.Date(),
                "9123456789",
                "ravi@gmail.com",
                "Chennai"
        );

        PatientDAO patientDAO = new PatientDAO() {

            @Override
            public int addPatient(Patient patient) {
                return 301;
            }

            @Override
            public Patient getPatientById(int patientId) {
                return patient;
            }

            @Override
            public void updatePatient(Patient patient) {
            }

            @Override
            public void deletePatient(int patientId) {
            }

            @Override
            public List<Patient> getAllPatients() {
                return List.of(patient);
            }
        };

        PatientServiceImplJdbc service =
                new PatientServiceImplJdbc(patientDAO);

        Patient result = service.getPatientById(301);

        assertNotNull(result);
        assertEquals(301, result.getPatientId());
        assertEquals("Ravi Kumar", result.getFullName());
        assertEquals("ravi@gmail.com", result.getEmail());
    }

    @Test
    void testClinicServiceDelegatesAddClinicToDAO() {

        Clinic clinic = new Clinic(
                401,
                "Apollo Clinic",
                "Coimbatore",
                601,
                "9000000000",
                2020
        );

        ClinicDAO clinicDAO = new ClinicDAO() {

            @Override
            public int addClinic(Clinic clinic) {
                return clinic.getClinicId();
            }

            @Override
            public Clinic getClinicById(int clinicId) {
                return null;
            }

            @Override
            public void updateClinic(Clinic clinic) {
            }

            @Override
            public void deleteClinic(int clinicId) {
            }

            @Override
            public List<Clinic> getAllClinics() {
                return List.of();
            }
        };

        ClinicServiceImplJdbc service =
                new ClinicServiceImplJdbc(clinicDAO);

        Integer result = service.addClinic(clinic);

        assertNotNull(result);
        assertEquals(401, result);
    }
}