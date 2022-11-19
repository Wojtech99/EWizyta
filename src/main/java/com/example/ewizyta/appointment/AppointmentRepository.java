package com.example.ewizyta.appointment;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    Set<Appointment> getAllByDoctor_Id(Long id);
}
