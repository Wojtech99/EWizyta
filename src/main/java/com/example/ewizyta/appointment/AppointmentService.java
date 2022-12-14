package com.example.ewizyta.appointment;

import com.example.ewizyta.doctor.Doctor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointmentToSave = AppointmentMapper.map(appointmentDto);
        Appointment savedAppointment = appointmentRepository.save(appointmentToSave);

        return AppointmentMapper.map(savedAppointment);
    }

    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    public Set<AppointmentDto> allDoctorAppointments(Doctor doctor) {
        Set<AppointmentDto> appointmentDtoSet = new HashSet<>();

        appointmentRepository.getAllByDoctor(doctor).ifPresent(appointments ->
                appointments.forEach(appointment ->
                        appointmentDtoSet.add(AppointmentMapper.map(appointment))));

        return appointmentDtoSet;
    }
}
