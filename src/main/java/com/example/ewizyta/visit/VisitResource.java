package com.example.ewizyta.visit;

import com.example.ewizyta.visit.VisitDtos.VisitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("/visit-resource")
public class VisitResource {

    private final VisitService visitService;

    public VisitResource(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/{id}")
    ResponseEntity<VisitDto> getVisit(@PathVariable("id") Long visitId) {
        return visitService.takeVisit(visitId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save-visit")
    ResponseEntity<VisitDto> saveVisit(@RequestBody VisitDto visitDto){
        VisitDto savedVisit = visitService.saveVisit(visitDto);

        URI savedVisitUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedVisit.getId())
                .toUri();

        return ResponseEntity.created(savedVisitUri).body(savedVisit);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteVisit(@PathVariable("id") Long visitId) {
        visitService.deleteVisit(visitId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/doctor-list")
    ResponseEntity<Set<VisitDto>> doctorList(@RequestBody Long doctorId) {
        Set<VisitDto> doctorSet= visitService.allPastDoctorsVisits(doctorId);

        return ResponseEntity.ok(doctorSet);
    }

    @GetMapping("/patient-list")
    ResponseEntity<Set<VisitDto>> patientList(@RequestBody Long patientId) {
            Set<VisitDto> patientsVisits = visitService.pastAllPatientsVisits(patientId);

            return ResponseEntity.ok(patientsVisits);
    }
}
