package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;

public class PatientServiceImplArraylist implements PatientService {

    private static List<Patient> patientList = new ArrayList<>();

    @Override
    public List<Patient> getAllPatients() {
        return patientList;
    }

    @Override
    public Integer addPatient(Patient patient) {
        patientList.add(patient);
        return patientList.size();
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        List<Patient> list = getAllPatients();
        list.sort(Comparator.comparing(Patient::getFullName));
        return list;
    }

    @Override
    public void emptyArrayList() {
        patientList = new ArrayList<Patient>();
    }
}
