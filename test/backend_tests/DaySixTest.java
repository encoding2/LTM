package com.edutech.progressive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.edutech.progressive.dao.DoctorDAO;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.impl.DoctorServiceImplJdbc;

public class DaySixTest {

    @Test
    void testGetAllDoctors() throws Exception {

        List<Doctor> doctors = new ArrayList<>();

        doctors.add(new Doctor(
                101,
                "Dr. Arun Kumar",
                "Cardiology",
                "9876543210",
                "arun@gmail.com",
                15));

        DoctorDAO doctorDAO = new DoctorDAO() {

            @Override
            public List<Doctor> getAllDoctors() throws SQLException {
                return doctors;
            }

            @Override
            public int addDoctor(Doctor doctor) throws SQLException {
                return 101;
            }

            @Override
            public Doctor getDoctorById(int doctorId) throws SQLException {
                return doctors.get(0);
            }

            @Override
            public void updateDoctor(Doctor doctor) throws SQLException {
            }

            @Override
            public void deleteDoctor(int doctorId) throws SQLException {
            }
        };

        DoctorServiceImplJdbc service =
                new DoctorServiceImplJdbc(doctorDAO);

        List<Doctor> result = service.getAllDoctors();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Dr. Arun Kumar", result.get(0).getFullName());
    }

    @Test
    void testAddDoctor() throws Exception {

        Doctor doctor = new Doctor(
                0,
                "Dr. Priya Sharma",
                "Neurology",
                "9123456789",
                "priya@gmail.com",
                10);

        DoctorDAO doctorDAO = new DoctorDAO() {

            @Override
            public int addDoctor(Doctor doctor) throws SQLException {
                return 102;
            }

            @Override
            public Doctor getDoctorById(int doctorId) throws SQLException {
                return null;
            }

            @Override
            public void updateDoctor(Doctor doctor) throws SQLException {
            }

            @Override
            public void deleteDoctor(int doctorId) throws SQLException {
            }

            @Override
            public List<Doctor> getAllDoctors() throws SQLException {
                return List.of();
            }
        };

        DoctorServiceImplJdbc service =
                new DoctorServiceImplJdbc(doctorDAO);

        Integer result = service.addDoctor(doctor);

        assertNotNull(result);
        assertEquals(102, result);
    }

    @Test
    void testGetDoctorById() throws Exception {

        Doctor doctor = new Doctor(
                103,
                "Dr. Kumar",
                "Dermatology",
                "9000000000",
                "kumar@gmail.com",
                8);

        DoctorDAO doctorDAO = new DoctorDAO() {

            @Override
            public Doctor getDoctorById(int doctorId) throws SQLException {
                return doctor;
            }

            @Override
            public int addDoctor(Doctor doctor) throws SQLException {
                return 103;
            }

            @Override
            public void updateDoctor(Doctor doctor) throws SQLException {
            }

            @Override
            public void deleteDoctor(int doctorId) throws SQLException {
            }

            @Override
            public List<Doctor> getAllDoctors() throws SQLException {
                return List.of(doctor);
            }
        };

        DoctorServiceImplJdbc service =
                new DoctorServiceImplJdbc(doctorDAO);

        Doctor result = service.getDoctorById(103);

        assertNotNull(result);
        assertEquals(103, result.getDoctorId());
        assertEquals("Dr. Kumar", result.getFullName());
        assertEquals(8, result.getYearsOfExperience());
    }

    @Test
    void testGetDoctorSortedByExperience() throws Exception {

        Doctor doctor1 = new Doctor(
                101,
                "Dr. Arun",
                "Cardiology",
                "9876543210",
                "arun@gmail.com",
                15);

        Doctor doctor2 = new Doctor(
                102,
                "Dr. Bala",
                "Neurology",
                "9876543211",
                "bala@gmail.com",
                5);

        Doctor doctor3 = new Doctor(
                103,
                "Dr. Charan",
                "Dermatology",
                "9876543212",
                "charan@gmail.com",
                10);

        DoctorDAO doctorDAO = new DoctorDAO() {

            @Override
            public List<Doctor> getAllDoctors() throws SQLException {
                return new ArrayList<>(List.of(
                        doctor1, doctor2, doctor3
                ));
            }

            @Override
            public int addDoctor(Doctor doctor) throws SQLException {
                return doctor.getDoctorId();
            }

            @Override
            public Doctor getDoctorById(int doctorId) throws SQLException {
                return null;
            }

            @Override
            public void updateDoctor(Doctor doctor) throws SQLException {
            }

            @Override
            public void deleteDoctor(int doctorId) throws SQLException {
            }
        };

        DoctorServiceImplJdbc service =
                new DoctorServiceImplJdbc(doctorDAO);

        List<Doctor> result =
                service.getDoctorSortedByExperience();

        assertNotNull(result);
        assertEquals(3, result.size());

        assertEquals(5, result.get(0).getYearsOfExperience());
        assertEquals(10, result.get(1).getYearsOfExperience());
        assertEquals(15, result.get(2).getYearsOfExperience());
    }
}