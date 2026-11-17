package com.edutech.progressive;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.progressive.controller.DoctorController;
import com.edutech.progressive.controller.PatientController;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.entity.Patient;

public class DayTenTest {

    @Test
    void testControllerClassesAndMethods() {

        assertNotNull(DoctorController.class);
        assertNotNull(PatientController.class);

        assertNotNull(
                DoctorController.class.getAnnotation(RestController.class)
        );

        assertNotNull(
                PatientController.class.getAnnotation(RestController.class)
        );

        // DoctorController methods
        checkMethod(
                DoctorController.class,
                "getAllDoctors",
                ResponseEntity.class
        );

        checkMethod(
                DoctorController.class,
                "getDoctorById",
                ResponseEntity.class,
                int.class
        );

        checkMethod(
                DoctorController.class,
                "addDoctor",
                ResponseEntity.class,
                Doctor.class
        );

        checkMethod(
                DoctorController.class,
                "updateDoctor",
                ResponseEntity.class,
                int.class,
                Doctor.class
        );

        checkMethod(
                DoctorController.class,
                "deleteDoctor",
                ResponseEntity.class,
                int.class
        );

        checkMethod(
                DoctorController.class,
                "getDoctorSortedByExperience",
                ResponseEntity.class
        );

        // PatientController methods
        checkMethod(
                PatientController.class,
                "getAllPatients",
                ResponseEntity.class
        );

        checkMethod(
                PatientController.class,
                "getPatientById",
                ResponseEntity.class,
                int.class
        );

        checkMethod(
                PatientController.class,
                "addPatient",
                ResponseEntity.class,
                Patient.class
        );

        checkMethod(
                PatientController.class,
                "updatePatient",
                ResponseEntity.class,
                int.class,
                Patient.class
        );

        checkMethod(
                PatientController.class,
                "deletePatient",
                ResponseEntity.class,
                int.class
        );

        checkMethod(
                PatientController.class,
                "getAllPatientFromArrayList",
                ResponseEntity.class
        );

        checkMethod(
                PatientController.class,
                "addPatientToArrayList",
                ResponseEntity.class,
                Patient.class
        );

        checkMethod(
                PatientController.class,
                "getAllPatientSortedByNameFromArrayList",
                ResponseEntity.class
        );
    }

    private void checkMethod(
            Class<?> controllerClass,
            String methodName,
            Class<?> returnType,
            Class<?>... parameterTypes) {

        try {
            Method method =
                    controllerClass.getDeclaredMethod(
                            methodName,
                            parameterTypes
                    );

            assertEquals(
                    returnType,
                    method.getReturnType(),
                    methodName + " should return ResponseEntity"
            );

        } catch (NoSuchMethodException e) {
            throw new AssertionError(
                    methodName + " method is missing in "
                            + controllerClass.getSimpleName()
            );
        }
    }
}