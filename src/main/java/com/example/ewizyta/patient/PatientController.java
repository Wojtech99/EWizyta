package com.example.ewizyta.patient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * show patient registration form
     * @param model Model
     * @return String
     */
    @GetMapping("/patient-registration")
    String getNewPatientForm(Model model) {
        model.addAttribute("patient", new PatientDto());

        return "new_registration_form";
    }

    /**
     * save new patient
     * @param patientDto PatientDto
     * @return String
     */
    @PostMapping("/patient-registration/save")
    String saveNewPatient(@ModelAttribute("patient") PatientDto patientDto) {
        patientService.registerNewPatient(patientDto);

        return "redirect:/";
    }
}
