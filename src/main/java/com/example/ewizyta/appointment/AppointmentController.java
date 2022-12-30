package com.example.ewizyta.appointment;

import com.example.ewizyta.doctor.*;
import com.example.ewizyta.patient.Patient;
import com.example.ewizyta.patient.PatientService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final PatientService patientService;


    public AppointmentController(AppointmentService appointmentService,
                                 DoctorService doctorService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    /**
     * load first step to add new appointment
     * @param model Model
     * @return String
     */
    @GetMapping("/add-appointment-01")
    String addAppointmentStepOne(Model model){
        List<String> specializationsList = Specialization.getSpecializationsDescription();

        model.addAttribute("ListOfSpecializations", specializationsList);

        return "add_appointment_01";
    }

    /**
     * load second step to add new appointment
     * @param model Model
     * @param nameSpecialization String
     * @param date Date (sql format)
     * @return String
     */
    @GetMapping("/add-appointment-02")
    String addAppointmentStepTwo(Model model, @RequestParam("specialization") String nameSpecialization,
                                 @RequestParam("date") Date date){
        AppointmentDto newAppointment = new AppointmentDto();
        newAppointment.setDateAppointment(date);

        Specialization DoctorSpecialization = Specialization.getSpecializationByDescription(nameSpecialization);
        Set<DoctorDto> doctorsWithParamSpecialization = doctorService.takeAllDoctorDtoWithSpecialisation(DoctorSpecialization);

        model.addAttribute("appointment", newAppointment);
        model.addAttribute("doctorsList", doctorsWithParamSpecialization);

        return "add_appointment_02";
    }

    /**
     * save new appointment
     * @param appointmentDto AppointmentDto
     * @param doctorId Long
     * @return String
     */
    @PostMapping("/save-appointment")
    String saveAppointment(@ModelAttribute("appointment") AppointmentDto appointmentDto,
                           @RequestParam("doctorId") Long doctorId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);

        final String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Patient currentPatient = patientService.getCurrentLoggedPatient(currentUserEmail);
        appointmentDto.setPatient(currentPatient);
        appointmentDto.setDoctor(doctor);

        appointmentService.saveAppointment(appointmentDto);

        return "redirect:/";
    }

    /**
     * Show All doctor appointments
     * @param model Model
     * @return String
     */
    @GetMapping("/doctors-appointment-list")
    String showAllAppointments(Model model) {
        final String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        Doctor currentLoggedDoctor = doctorService.getDoctorByEmail(currentUserEmail);
       Set<AppointmentDto> doctorsAppointmentSet = appointmentService.allDoctorAppointments(currentLoggedDoctor);

       model.addAttribute("list", doctorsAppointmentSet);

       return "doctor_appointments";
    }

    /**
     * Delete appointment
     * @param appointmentId Long
     * @return String
     */
    @RequestMapping(
            value = "/doctors-appointment-list/delete/{id}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteAppointment(@PathVariable("id") Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);

        return "redirect:/doctors-appointment-list";
    }
}
