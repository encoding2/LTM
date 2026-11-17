package com.edutech.progressive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.entity.Patient;

public class DayElevenTest {

    @Test
    void testEntityAnnotation() {

        assertNotNull(
                Clinic.class.getAnnotation(Entity.class),
                "Clinic should have @Entity annotation"
        );

        assertNotNull(
                Doctor.class.getAnnotation(Entity.class),
                "Doctor should have @Entity annotation"
        );

        assertNotNull(
                Patient.class.getAnnotation(Entity.class),
                "Patient should have @Entity annotation"
        );
    }

    @Test
    void testIdAnnotation() throws Exception {

        Field clinicId = Clinic.class.getDeclaredField("clinicId");
        Field doctorId = Doctor.class.getDeclaredField("doctorId");
        Field patientId = Patient.class.getDeclaredField("patientId");

        assertNotNull(
                clinicId.getAnnotation(Id.class),
                "Clinic clinicId should have @Id annotation"
        );

        assertNotNull(
                doctorId.getAnnotation(Id.class),
                "Doctor doctorId should have @Id annotation"
        );

        assertNotNull(
                patientId.getAnnotation(Id.class),
                "Patient patientId should have @Id annotation"
        );
    }

    @Test
    void testGeneratedValueAnnotation() throws Exception {

        Field clinicId = Clinic.class.getDeclaredField("clinicId");
        Field doctorId = Doctor.class.getDeclaredField("doctorId");
        Field patientId = Patient.class.getDeclaredField("patientId");

        assertNotNull(
                clinicId.getAnnotation(GeneratedValue.class),
                "Clinic clinicId should have @GeneratedValue"
        );

        assertNotNull(
                doctorId.getAnnotation(GeneratedValue.class),
                "Doctor doctorId should have @GeneratedValue"
        );

        assertNotNull(
                patientId.getAnnotation(GeneratedValue.class),
                "Patient patientId should have @GeneratedValue"
        );
    }

    @Test
    void testIdentityGenerationStrategy() throws Exception {

        Field clinicId = Clinic.class.getDeclaredField("clinicId");
        Field doctorId = Doctor.class.getDeclaredField("doctorId");
        Field patientId = Patient.class.getDeclaredField("patientId");

        GeneratedValue clinicGenerated =
                clinicId.getAnnotation(GeneratedValue.class);

        GeneratedValue doctorGenerated =
                doctorId.getAnnotation(GeneratedValue.class);

        GeneratedValue patientGenerated =
                patientId.getAnnotation(GeneratedValue.class);

        assertEquals(
                GenerationType.IDENTITY,
                clinicGenerated.strategy(),
                "Clinic should use GenerationType.IDENTITY"
        );

        assertEquals(
                GenerationType.IDENTITY,
                doctorGenerated.strategy(),
                "Doctor should use GenerationType.IDENTITY"
        );

        assertEquals(
                GenerationType.IDENTITY,
                patientGenerated.strategy(),
                "Patient should use GenerationType.IDENTITY"
        );
    }
}