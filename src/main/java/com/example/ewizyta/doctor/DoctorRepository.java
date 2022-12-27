package com.example.ewizyta.doctor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    @Query("select d from Doctor d")
    List<Doctor> getAll();
}
