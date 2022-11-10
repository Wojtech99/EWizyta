package com.example.ewizyta.visit;

import com.example.ewizyta.doctor.Doctor;
import com.example.ewizyta.patient.Patient;

import java.util.Objects;

public class VisitDto {
    private Long id;
    private String illness;
    private String description;
    private String prescription;
    private Patient patient;
    private Doctor doctor;

    public VisitDto(Long id, String illness, String description, String prescription, Patient patient, Doctor doctor) {
        this.id = id;
        this.illness = illness;
        this.description = description;
        this.prescription = prescription;
        this.patient = patient;
        this.doctor = doctor;
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
        VisitDto visitDto = (VisitDto) o;
        return Objects.equals(id, visitDto.id) && Objects.equals(illness, visitDto.illness) && Objects.equals(description, visitDto.description) && Objects.equals(prescription, visitDto.prescription) && Objects.equals(patient, visitDto.patient) && Objects.equals(doctor, visitDto.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, illness, description, prescription, patient, doctor);
    }
}
