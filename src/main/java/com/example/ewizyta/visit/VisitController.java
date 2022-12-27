package com.example.ewizyta.visit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/add-visit")
    String addVisit(Model model) {
        model.addAttribute("visit", new VisitDto());

        return "new-visit-form";
    }

    @PostMapping("/save-visit")
    String saveVisit(@RequestParam("Visit") VisitDto visitDto) {
        visitService.saveVisit(visitDto);

        return "redirect:/add-visit";
    }

    @GetMapping("/all-patient-visits")
    String patientList(Model model){
        //przy spring security dodać tu zalogowanego pacjenta
        Set<VisitDto> patientList = visitService.pastAllPatientsVisits(1l);

        model.addAttribute("list", patientList);

        return "doctor_visits";
    }

    @GetMapping("/all-doctors-visits")
    String doctorList(Model model) {
        //przy spring security dodać tu zalogowanego doktora
        Set<VisitDto> doctorList = visitService.allPastDoctorsVisits(1l);

        model.addAttribute("list", doctorList);

        return "doctor_visits";
    }

    @RequestMapping(
            value = "/all-doctors-visits/delete/{id}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteVisit(@PathVariable("id") Long visitId){
        visitService.deleteVisit(visitId);

        return "redirect:/all-doctors-visits";
    }
}
