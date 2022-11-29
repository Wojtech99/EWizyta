package com.example.ewizyta.visit;

import com.example.ewizyta.doctor.DoctorDto;
import com.example.ewizyta.patient.PatientDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/visit")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/add")
    String addVisit(Model model) {
        model.addAttribute("visit", new VisitDto());

        return "new-visit-form";
    }

    @PostMapping("/save")
    String saveVisit(@RequestParam("Visit") VisitDto visitDto) {
        visitService.saveVisit(visitDto);

        return "redirect:/add";
    }

    @GetMapping("/patientName-list")
    String patientList(Model model){
        //przy spring security dodać tu zalogowanego pacjenta
        Set<VisitDto> patientList = visitService.pastAllPatientsVisits(1l);

        model.addAttribute("list", patientList);

        return "visits";
    }

    @GetMapping("/doctorName-list")
    String doctorList(Model model) {
        //przy spring security dodać tu zalogowanego doktora
        Set<VisitDto> doctorList = visitService.allPastDoctorsVisits(1l);

        model.addAttribute("list", doctorList);

        return "visits";
    }

    @RequestMapping(
            value = "/doctorName-list/delete/{id}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteVisit(@PathVariable("id") Long visitId){
        visitService.deleteVisit(visitId);

        return "redirect:/doctorName-list";
    }
}
