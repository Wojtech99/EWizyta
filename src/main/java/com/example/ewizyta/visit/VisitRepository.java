package com.example.ewizyta.visit;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface VisitRepository extends CrudRepository<Visit, Long> {
    Set<Visit> findAllByPatient_Id(Long patientId);

    Optional<Set<Visit>> findAllByDoctor_Id(Long doctorId);
}
