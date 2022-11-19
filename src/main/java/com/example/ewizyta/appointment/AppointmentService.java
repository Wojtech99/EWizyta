package com.example.ewizyta.appointment;

import com.example.ewizyta.doctor.DoctorDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public void deleteAppointment(AppointmentDto appointmentDto) {
        appointmentRepository.deleteById(appointmentDto.getId());
    }

    public Set<AppointmentDto> allDoctorsAppointments(DoctorDto doctorDto) {
        Set<AppointmentDto> appointmentDtoSet = new HashSet<>();

        appointmentRepository.getAllByDoctor_Id(doctorDto.getId()).ifPresent(appointments ->
                appointments.forEach(appointment ->
                        appointmentDtoSet.add(AppointmentMapper.map(appointment))));

        return appointmentDtoSet;
    }
}
