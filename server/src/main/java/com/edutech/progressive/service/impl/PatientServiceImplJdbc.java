package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.PatientDAO;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;

public class PatientServiceImplJdbc implements PatientService {

    private PatientDAO patientDAO;

    public PatientServiceImplJdbc(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    @Override
    public Integer addPatient(Patient patient) {
        return patientDAO.addPatient(patient);
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        return new ArrayList<>();
    }

    @Override
    public void updatePatient(Patient patient) {
    }

    @Override
    public void deletePatient(int patientId) {
    }

    @Override
    public Patient getPatientById(int patientId) {
        return patientDAO.getPatientById(patientId);
    }
}
