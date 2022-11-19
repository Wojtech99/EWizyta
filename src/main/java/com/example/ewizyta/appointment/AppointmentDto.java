package com.example.ewizyta.appointment;

import com.example.ewizyta.doctor.Doctor;
import com.example.ewizyta.patient.Patient;

import java.sql.Date;
import java.util.Objects;

public class AppointmentDto {
    private Long id;
    private Date dateAppointment;
    private Doctor doctor;
    private Patient patient;

    public AppointmentDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentDto that = (AppointmentDto) o;
        return Objects.equals(id, that.id) && Objects.equals(dateAppointment, that.dateAppointment)
                && Objects.equals(doctor, that.doctor)
                && Objects.equals(patient, that.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateAppointment, doctor, patient);
    }
}
