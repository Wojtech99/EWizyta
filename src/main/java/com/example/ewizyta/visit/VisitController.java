package com.example.ewizyta.visit;

import com.example.ewizyta.doctor.Doctor;
import com.example.ewizyta.doctor.DoctorService;
import com.example.ewizyta.patient.Patient;
import com.example.ewizyta.patient.PatientService;
import com.example.ewizyta.visit.VisitDtos.VisitDto;
import com.example.ewizyta.visit.VisitDtos.VisitDtoThymeleaf;
import com.example.ewizyta.visit.VisitMappers.VisitDtoThymeleafMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public VisitController(VisitService visitService, DoctorService doctorService, PatientService patientService) {
        this.visitService = visitService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    /**
     * Show new visit form
     * @param model Model
     * @return String
     */
    @GetMapping("/add-visit")
    String addVisit(Model model) {
        model.addAttribute("visit", new VisitDto());

        return "new_visit_form";
    }

    /**
     * Save new Visit
     * @param visitDto VisitDto
     * @param personalId Integer
     * @return String
     */
    @PostMapping("/save-visit")
    String saveVisit(@ModelAttribute("Visit") VisitDto visitDto,
                     @RequestParam("personalId") Integer personalId) {
        Patient patient = patientService.findPatientByPersonalId(personalId);
        final String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Doctor doctor = doctorService.getDoctorByEmail(currentUserEmail);
        visitDto.setDoctor(doctor);
        visitDto.setPatient(patient);

        visitService.saveVisit(visitDto);

        return "redirect:/add-visit";
    }

    /**
     * Show all past patients visit
     * @param model Model
     * @return String
     */
    @GetMapping("/all-patient-visits")
    String patientList(Model model){
        final String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        final Patient patient = patientService.getCurrentLoggedPatient(currentUserEmail);


        Set<VisitDtoThymeleaf> patientList = visitService.pastAllPatientsVisits(patient.getId()).stream()
                .map(VisitDtoThymeleafMapper::map)
                .collect(Collectors.toSet());

        model.addAttribute("list", patientList);

        return "patient_visits";
    }

    /**
     * show all past doctor visits
     * @param model Model
     * @return String
     */
    @GetMapping("/all-doctors-visits")
    String doctorList(Model model) {
        final String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        final Doctor doctor = doctorService.getDoctorByEmail(currentUserEmail);

        Set<VisitDtoThymeleaf> doctorList = doctor.getPastVisits().stream()
                .map(VisitDtoThymeleafMapper::map)
                .collect(Collectors.toSet());

        model.addAttribute("DoctorList", doctorList);

        return "doctor_visits";
    }

    /**
     * delete visit
     * @param visitId Long
     * @return String
     */
    @RequestMapping(
            value = "/all-doctors-visits/delete/{id}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteVisit(@PathVariable("id") Long visitId){
        visitService.deleteVisit(visitId);

        return "redirect:/all-doctors-visits";
    }

    /**
     * show single visit
     * @param visitId Long
     * @param model Model
     * @return String
     */
    @GetMapping("/all-doctors-visits/visit-details/{id}")
    String showVisitDetails(@PathVariable("id") Long visitId, Model model) {
        if (visitService.takeVisit(visitId).isPresent()) {
            VisitDtoThymeleaf visitDtoThymeleaf = VisitDtoThymeleafMapper.map(visitService.takeVisit(visitId).get());
            model.addAttribute("singleVisit", visitDtoThymeleaf);
        }

        return "visit_details";
    }
}
