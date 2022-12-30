package com.example.ewizyta.appointment;

import com.example.ewizyta.doctor.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    Optional<Set<Appointment>> getAllByDoctor(Doctor doctor);
}
