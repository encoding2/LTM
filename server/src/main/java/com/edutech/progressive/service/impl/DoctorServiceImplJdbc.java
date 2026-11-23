package com.edutech.progressive.service.impl;

import com.edutech.progressive.dao.DoctorDAO;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class DoctorServiceImplJdbc implements DoctorService {

    private DoctorDAO doctorDAO;

    public DoctorServiceImplJdbc(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    @Override
    public List<Doctor> getAllDoctors() throws Exception {
        try {
            return doctorDAO.getAllDoctors();
        } catch (SQLException e) {
            throw new Exception("Failed to retrieve all doctors", e);
        }
    }

    @Override
    public Doctor getDoctorById(int doctorId) throws Exception {
        try {
            return doctorDAO.getDoctorById(doctorId);
        } catch (SQLException e) {
            throw new Exception("Failed to retrieve doctor with ID: " + doctorId, e);
        }
    }

    @Override
    public Integer addDoctor(Doctor doctor) throws Exception {
        try {
            return doctorDAO.addDoctor(doctor);
        } catch (SQLException e) {
            throw new Exception("Failed to add doctor: " + doctor.getFullName(), e);
        }
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() throws Exception {
        try {
            List<Doctor> doctors = doctorDAO.getAllDoctors();
            doctors.sort(Comparator.comparing(Doctor::getYearsOfExperience));
            return doctors;
        } catch (SQLException e) {
            throw new Exception("Failed to retrieve doctors sorted by experience", e);
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) throws Exception {
        try {
            doctorDAO.updateDoctor(doctor);
        } catch (SQLException e) {
            throw new Exception("Failed to update doctor with ID: " + doctor.getDoctorId(), e);
        }
    }

    @Override
    public void deleteDoctor(int doctorId) throws Exception {
        try {
            doctorDAO.deleteDoctor(doctorId);
        } catch (SQLException e) {
            throw new Exception("Failed to delete doctor with ID: " + doctorId, e);
        }
    }
}
