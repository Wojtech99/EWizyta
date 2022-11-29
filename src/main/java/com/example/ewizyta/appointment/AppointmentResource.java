package com.example.ewizyta.appointment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("resource-appointment")
public class AppointmentResource {

    private final AppointmentService appointmentService;

    public AppointmentResource(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/save-appointment")
    ResponseEntity<AppointmentDto> saveAppointment(@RequestBody AppointmentDto appointmentDto){
        AppointmentDto savedAppointment = appointmentService.saveAppointment(appointmentDto);

        URI savedAppointmentUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAppointment.getId())
                .toUri();

        return ResponseEntity.created(savedAppointmentUri).body(savedAppointment);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    ResponseEntity<Set<AppointmentDto>> AppointmentsDoctorList(@RequestBody Long doctorId) {
        Set<AppointmentDto> doctorsList = appointmentService.allDoctorAppointments(doctorId);

        return ResponseEntity.ok(doctorsList);
    }
}
