package com.edutech.progressive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.edutech.progressive.dao.ClinicDAO;
import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.impl.ClinicServiceImplJdbc;

public class DaySevenTest {

    @Test
    void testGetAllClinics() throws Exception {

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
            public List<Clinic> getAllClinics() throws SQLException {
                return clinics;
            }

            @Override
            public int addClinic(Clinic clinic) throws SQLException {
                return 101;
            }

            @Override
            public Clinic getClinicById(int clinicId) throws SQLException {
                return clinic;
            }

            @Override
            public void updateClinic(Clinic clinic) throws SQLException {
            }

            @Override
            public void deleteClinic(int clinicId) throws SQLException {
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
    void testGetClinicById() throws Exception {

        Clinic clinic = new Clinic(
                102,
                "Apollo Clinic",
                "Chennai",
                502,
                "9123456789",
                2020
        );

        ClinicDAO clinicDAO = new ClinicDAO() {

            @Override
            public Clinic getClinicById(int clinicId) throws SQLException {
                return clinic;
            }

            @Override
            public int addClinic(Clinic clinic) throws SQLException {
                return 102;
            }

            @Override
            public void updateClinic(Clinic clinic) throws SQLException {
            }

            @Override
            public void deleteClinic(int clinicId) throws SQLException {
            }

            @Override
            public List<Clinic> getAllClinics() throws SQLException {
                return List.of(clinic);
            }
        };

        ClinicServiceImplJdbc service =
                new ClinicServiceImplJdbc(clinicDAO);

        Clinic result = service.getClinicById(102);

        assertNotNull(result);
        assertEquals(102, result.getClinicId());
        assertEquals("Apollo Clinic", result.getClinicName());
        assertEquals("Chennai", result.getLocation());
    }

    @Test
    void testAddClinic() throws Exception {

        Clinic clinic = new Clinic(
                103,
                "Health Plus Clinic",
                "Coimbatore",
                503,
                "9000000000",
                2018
        );

        ClinicDAO clinicDAO = new ClinicDAO() {

            @Override
            public int addClinic(Clinic clinic) throws SQLException {
                return 103;
            }

            @Override
            public Clinic getClinicById(int clinicId) throws SQLException {
                return null;
            }

            @Override
            public void updateClinic(Clinic clinic) throws SQLException {
            }

            @Override
            public void deleteClinic(int clinicId) throws SQLException {
            }

            @Override
            public List<Clinic> getAllClinics() throws SQLException {
                return List.of();
            }
        };

        ClinicServiceImplJdbc service =
                new ClinicServiceImplJdbc(clinicDAO);

        Integer result = service.addClinic(clinic);

        assertNotNull(result);
        assertEquals(103, result);
    }

    @Test
    void testUpdateClinic() throws Exception {

        Clinic clinic = new Clinic(
                104,
                "Updated Care Clinic",
                "Madurai",
                504,
                "8888888888",
                2022
        );

        final boolean[] updated = {false};

        ClinicDAO clinicDAO = new ClinicDAO() {

            @Override
            public void updateClinic(Clinic clinic) throws SQLException {
                updated[0] = true;
            }

            @Override
            public int addClinic(Clinic clinic) throws SQLException {
                return 104;
            }

            @Override
            public Clinic getClinicById(int clinicId) throws SQLException {
                return clinic;
            }

            @Override
            public void deleteClinic(int clinicId) throws SQLException {
            }

            @Override
            public List<Clinic> getAllClinics() throws SQLException {
                return List.of(clinic);
            }
        };

        ClinicServiceImplJdbc service =
                new ClinicServiceImplJdbc(clinicDAO);

        service.updateClinic(clinic);

        assertEquals(true, updated[0]);
    }
}