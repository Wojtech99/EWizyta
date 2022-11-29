package com.example.ewizyta.appointment;

import com.example.ewizyta.doctor.DoctorDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/add")
    String addAppointment(Model model){
        model.addAttribute("appointment", new AppointmentDto());

        return "add-appointment";
    }

    @PostMapping("/save")
    String saveAppointment(@RequestParam("appointment") AppointmentDto appointmentDto) {
        appointmentService.saveAppointment(appointmentDto);

        return "redirect:/";
    }

    @GetMapping("/doctors-list")
    String showAllAppointments(Model model) {
        // przy implementacji spring-security dodać doktora (chodzi o aktywnie zalogowanego doktora)

       Set<AppointmentDto> doctorsAppointmentSet = appointmentService.allDoctorAppointments(new DoctorDto());

       model.addAttribute("list", doctorsAppointmentSet);

       return "doctor-appointments";
    }

    @RequestMapping(
            value = "delete/{id}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteAppointment(@PathVariable(name = "id") Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);

        return "redirect:/doctors-list";
    }
}
