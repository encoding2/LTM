package com.edutech.progressive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.edutech.progressive.entity.Doctor;

public class DayOneTest {

    @Test
    void testDoctorConstructorAndGetters() {
        Doctor doctor = new Doctor(
                101,
                "Dr. Arun Kumar",
                "Cardiology",
                "9876543210",
                "arun@gmail.com",
                10);

        assertEquals(101, doctor.getDoctorId());
        assertEquals("Dr. Arun Kumar", doctor.getFullName());
        assertEquals("Cardiology", doctor.getSpecialty());
        assertEquals("9876543210", doctor.getContactNumber());
        assertEquals("arun@gmail.com", doctor.getEmail());
        assertEquals(10, doctor.getYearsOfExperience());
    }

    @Test
    void testDoctorSettersAndGetters() {
        Doctor doctor = new Doctor();

        doctor.setDoctorId(102);
        doctor.setFullName("Dr. Priya Sharma");
        doctor.setSpecialty("Neurology");
        doctor.setContactNumber("9123456789");
        doctor.setEmail("priya@gmail.com");
        doctor.setYearsOfExperience(8);

        assertEquals(102, doctor.getDoctorId());
        assertEquals("Dr. Priya Sharma", doctor.getFullName());
        assertEquals("Neurology", doctor.getSpecialty());
        assertEquals("9123456789", doctor.getContactNumber());
        assertEquals("priya@gmail.com", doctor.getEmail());
        assertEquals(8, doctor.getYearsOfExperience());
    }
}