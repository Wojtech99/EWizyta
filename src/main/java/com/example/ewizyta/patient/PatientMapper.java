package com.example.ewizyta.patient;

public class PatientMapper {
    static PatientDto map(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getLastName(),
                patient.getPersonalId(),
                patient.getEmail(),
                patient.getPassword(),
                patient.getBirthDate(),
                patient.getRole(),
                patient.getPastVisits()
        );
    }

    static Patient map(PatientDto patientDto) {
        Patient patient = new Patient(
                patientDto.getName(),
                patientDto.getLastName(),
                patientDto.getPersonalId(),
                patientDto.getEmail(),
                patientDto.getPassword(),
                patientDto.getBirthDate()
        );

        patient.setRole(patient.getRole());
        patient.setPastVisits(patientDto.getPastVisits());

        return patient;
    }
}
