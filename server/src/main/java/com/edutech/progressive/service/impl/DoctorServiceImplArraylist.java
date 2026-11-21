package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

public class DoctorServiceImplArraylist implements DoctorService {

    private static List<Doctor> doctorList = new ArrayList<>();

    @Override
    public void emptyArrayList() {
        doctorList = new ArrayList<Doctor>();
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        doctorList.add(doctor);
        return doctorList.size();
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        List<Doctor> list = getAllDoctors();
        list.sort(Comparator.comparing(Doctor::getYearsOfExperience));
        return list;
    }
}
