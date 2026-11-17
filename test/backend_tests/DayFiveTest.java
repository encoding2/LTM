package com.edutech.progressive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.impl.DoctorServiceImplArraylist;
import com.edutech.progressive.service.impl.PatientServiceImplArraylist;

public class DayFiveTest {

    private DoctorServiceImplArraylist doctorService;
    private PatientServiceImplArraylist patientService;

    @BeforeEach
    void setUp() {
        doctorService = new DoctorServiceImplArraylist();
        patientService = new PatientServiceImplArraylist();

        doctorService.emptyArrayList();
        patientService.emptyArrayList();
    }

    @Test
    void testDoctorComparableSortsByYearsOfExperience() {
        Doctor doctor1 = new Doctor(
                101, "Dr. Arun", "Cardiology",
                "9876543210", "arun@gmail.com", 15);

        Doctor doctor2 = new Doctor(
                102, "Dr. Bala", "Neurology",
                "9876543211", "bala@gmail.com", 5);

        assertTrue(doctor1.compareTo(doctor2) > 0);
        assertTrue(doctor2.compareTo(doctor1) < 0);
    }

    @Test
    void testDoctorServiceSortsByExperience() {
        doctorService.addDoctor(
                new Doctor(101, "Dr. Arun", "Cardiology",
                        "9876543210", "arun@gmail.com", 15));

        doctorService.addDoctor(
                new Doctor(102, "Dr. Bala", "Neurology",
                        "9876543211", "bala@gmail.com", 5));

        doctorService.addDoctor(
                new Doctor(103, "Dr. Charan", "Dermatology",
                        "9876543212", "charan@gmail.com", 10));

        List<Doctor> doctors = doctorService.getDoctorSortedByExperience();

        assertEquals(3, doctors.size());
        assertEquals(5, doctors.get(0).getYearsOfExperience());
        assertEquals(10, doctors.get(1).getYearsOfExperience());
        assertEquals(15, doctors.get(2).getYearsOfExperience());
    }

    @Test
    void testPatientComparableSortsByName() {
        Patient patient1 = new Patient(
                201, "Zara", new Date(),
                "9876543210", "zara@gmail.com", "Chennai");

        Patient patient2 = new Patient(
                202, "Arun", new Date(),
                "9876543211", "arun@gmail.com", "Chennai");

        assertTrue(patient1.compareTo(patient2) > 0);
        assertTrue(patient2.compareTo(patient1) < 0);
    }

    @Test
    void testPatientServiceSortsByName() {
        patientService.addPatient(
                new Patient(201, "Zara", new Date(),
                        "9876543210", "zara@gmail.com", "Chennai"));

        patientService.addPatient(
                new Patient(202, "Arun", new Date(),
                        "9876543211", "arun@gmail.com", "Chennai"));

        patientService.addPatient(
                new Patient(203, "Kumar", new Date(),
                        "9876543212", "kumar@gmail.com", "Chennai"));

        List<Patient> patients =
                patientService.getAllPatientSortedByName();

        assertEquals(3, patients.size());
        assertEquals("Arun", patients.get(0).getFullName());
        assertEquals("Kumar", patients.get(1).getFullName());
        assertEquals("Zara", patients.get(2).getFullName());
    }
}