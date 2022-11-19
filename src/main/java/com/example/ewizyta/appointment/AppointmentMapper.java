package com.example.ewizyta.appointment;

public class AppointmentMapper {
    static AppointmentDto map(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();

        appointmentDto.setId(appointmentDto.getId());
        appointmentDto.setDateAppointment(appointment.getDateAppointment());
        appointmentDto.setDoctor(appointment.getDoctor());
        appointmentDto.setPatient(appointment.getPatient());

        return appointmentDto;
    }

    static Appointment map(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();

        appointment.setDateAppointment(appointmentDto.getDateAppointment());
        appointment.setDoctor(appointmentDto.getDoctor());
        appointment.setPatient(appointmentDto.getPatient());

        return appointment;
    }
}
