package com.example.ewizyta.appointment;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    Optional<Set<Appointment>> getAllByDoctor_Email(String email);
}
