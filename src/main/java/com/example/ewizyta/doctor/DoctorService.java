package com.example.ewizyta.doctor;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Set<DoctorDto> takeAllDoctorDtoWithSpecialisation(Specialization specialization) {
        return doctorRepository.getDoctorsBySpecialization(specialization).stream()
                .map(DoctorMapper::map)
                .collect(Collectors.toSet());
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.getDoctorById(id);
    }

    public Doctor getDoctorByEmail(String email) {
        return doctorRepository.getDoctorByEmail(email);
    }

}
