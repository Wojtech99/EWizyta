package com.example.ewizyta.visit;

import com.example.ewizyta.doctor.Doctor;
import com.example.ewizyta.patient.Patient;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String illness;
    private String description;
    private String prescription;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Visit(){}

    public Visit(String illness, String description, String prescription) {
        this.illness = illness;
        this.description = description;
        this.prescription = prescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(id, visit.id) && Objects.equals(illness, visit.illness) &&
                Objects.equals(description, visit.description) &&
                Objects.equals(prescription, visit.prescription) &&
                Objects.equals(patient, visit.patient) && Objects.equals(doctor, visit.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, illness, description, prescription, patient, doctor);
    }
}
