package com.example.ewizyta.appointment;

import com.example.ewizyta.doctor.Doctor;
import com.example.ewizyta.patient.Patient;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateAppointment;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Appointment(){}

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
}
