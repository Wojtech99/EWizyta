package com.example.ewizyta.visit.VisitDtos;


import java.util.Objects;

public record VisitDtoThymeleaf(Long id, String illness, String description, String prescription,
                                String patientFullName, String patientEmail, Integer patientPersonalId,
                                String doctorFullName, String doctorSpecialization) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitDtoThymeleaf that = (VisitDtoThymeleaf) o;
        return Objects.equals(illness, that.illness) &&
                Objects.equals(description, that.description) &&
                Objects.equals(prescription, that.prescription) &&
                Objects.equals(patientFullName, that.patientFullName) &&
                Objects.equals(patientEmail, that.patientEmail) &&
                Objects.equals(patientPersonalId, that.patientPersonalId) &&
                Objects.equals(doctorFullName, that.doctorFullName) &&
                Objects.equals(doctorSpecialization, that.doctorSpecialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(illness, description, prescription, patientFullName,
                patientEmail, patientPersonalId, doctorFullName, doctorSpecialization);
    }
}
