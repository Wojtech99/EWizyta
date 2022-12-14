package com.example.ewizyta.patient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    @Query("select p from Patient p")
    List<Patient> getAll();

    Patient getPatientsByEmail(String email);

    Optional<Patient> findPatientByPersonalId(Integer personalId);
}
