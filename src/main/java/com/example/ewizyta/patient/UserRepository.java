package com.example.ewizyta.patient;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Patient, Long> {
}
