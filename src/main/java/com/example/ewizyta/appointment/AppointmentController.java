package com.example.ewizyta.appointment;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/add-appointment")
    String addAppointment(Model model){
        model.addAttribute("appointment", new AppointmentDto());

        return "add-appointment";
    }

    @PostMapping("/save")
    String saveAppointment(@RequestParam("appointment") AppointmentDto appointmentDto) {
        String CurrentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        //przy spring security wstawić tu pacjenta(aktywnie zalogowany pacjent)
        //przy spring security wstawić tu doktora(wybranego z listy)
        appointmentService.saveAppointment(appointmentDto);

        return "redirect:/";
    }

    @GetMapping("/doctors-appointment-list")
    String showAllAppointments(Model model) {
        // przy implementacji spring-security dodać doktora (chodzi o aktywnie zalogowanego doktora)
        String CurrentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

       Set<AppointmentDto> doctorsAppointmentSet = appointmentService.allDoctorAppointments(CurrentUserEmail);

       model.addAttribute("list", doctorsAppointmentSet);

       return "doctor-appointments";
    }

    @RequestMapping(
            value = "/doctors-appointment-list/delete/{id}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteAppointment(@PathVariable(name = "id") Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);

        return "redirect:/doctors-appointment-list";
    }
}
