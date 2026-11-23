package com.edutech.progressive.dao;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public int addDoctor(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO doctor (full_name, specialty, contact_number, email, years_of_experience) "
                   + "VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int generatedId = -1;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getSpecialty());
            ps.setString(3, doctor.getContactNumber());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getYearsOfExperience());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
                doctor.setDoctorId(generatedId);
            }
            return generatedId;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeQuietly(rs, ps, connection);
        }
    }

    @Override
    public Doctor getDoctorById(int doctorId) throws SQLException {
        String sql = "SELECT doctor_id, full_name, specialty, contact_number, email, years_of_experience "
                   + "FROM doctor WHERE doctor_id = ?";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, doctorId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
            return null;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeQuietly(rs, ps, connection);
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) throws SQLException {
        String sql = "UPDATE doctor SET full_name = ?, specialty = ?, contact_number = ?, "
                   + "email = ?, years_of_experience = ? WHERE doctor_id = ?";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getSpecialty());
            ps.setString(3, doctor.getContactNumber());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getYearsOfExperience());
            ps.setInt(6, doctor.getDoctorId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeQuietly(null, ps, connection);
        }
    }

    @Override
    public void deleteDoctor(int doctorId) throws SQLException {
        String sql = "DELETE FROM doctor WHERE doctor_id = ?";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, doctorId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeQuietly(null, ps, connection);
        }
    }

    @Override
    public List<Doctor> getAllDoctors() throws SQLException {
        String sql = "SELECT doctor_id, full_name, specialty, contact_number, email, years_of_experience "
                   + "FROM doctor";
        List<Doctor> doctors = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                doctors.add(mapRow(rs));
            }
            return doctors;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeQuietly(rs, ps, connection);
        }
    }

    private Doctor mapRow(ResultSet rs) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(rs.getInt("doctor_id"));
        doctor.setFullName(rs.getString("full_name"));
        doctor.setSpecialty(rs.getString("specialty"));
        doctor.setContactNumber(rs.getString("contact_number"));
        doctor.setEmail(rs.getString("email"));
        doctor.setYearsOfExperience(rs.getInt("years_of_experience"));
        return doctor;
    }

    private void closeQuietly(ResultSet rs, PreparedStatement ps, Connection con) {
        try { if (rs != null) rs.close(); } catch (SQLException ignored) { }
        try { if (ps != null) ps.close(); } catch (SQLException ignored) { }
        try { if (con != null) con.close(); } catch (SQLException ignored) { }
    }
}
