package com.example.ewizyta.doctor;

public class DoctorMapper {
    static DoctorDto map(Doctor doctor) {
        return new DoctorDto(
                doctor.getRole().getId(),
                doctor.getName(),
                doctor.getLastName(),
                doctor.getEmail(),
                doctor.getPassword(),
                doctor.getRole(),
                doctor.getPastVisits(),
                doctor.getPatientQueue()
        );
    }

    static Doctor map(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();

        doctor.setName(doctorDto.getName());
        doctor.setLastName(doctorDto.getLastName());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setPassword(doctorDto.getPassword());
        doctor.setRole(doctorDto.getRole());
        doctor.setPastVisits(doctorDto.getPastVisits());
        doctor.setPatientQueue(doctorDto.getPatientQueue());

        return doctor;
    }
}
