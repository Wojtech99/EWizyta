package com.example.ewizyta.patient;

import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient getCurrentLoggedPatient(String email) {
        return patientRepository.getPatientsByEmail(email);
    }
}
