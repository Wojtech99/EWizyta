package com.example.ewizyta.visit;

import com.example.ewizyta.doctor.DoctorDto;
import com.example.ewizyta.patient.PatientDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }


    public VisitDto saveVisit(VisitDto visitDto) {
        Visit visitToSave = VisitMapper.map(visitDto);
        Visit savedVisit = visitRepository.save(visitToSave);

        return VisitMapper.map(savedVisit);
    }

    public Set<VisitDto> pastAllPatientsVisits(PatientDto patientDto) {
        Set<VisitDto> visitDtoSet = new HashSet<>();

        visitRepository.findAllByPatient_Id(patientDto.getId()).ifPresent(visits ->
                visits.forEach(visit->
                        visitDtoSet.add(VisitMapper.map(visit))));

        return visitDtoSet;

    }

    public void deleteVisit(Long visitId) {
        visitRepository.deleteById(visitId);
    }

    public Set<VisitDto> allPastDoctorsVisits(DoctorDto doctorDto) {
        Set<VisitDto> visitDtoSet = new HashSet<>();

        visitRepository.findAllByDoctor_Id(doctorDto.getId()).ifPresent(visits ->
                visits.forEach(visit->
                        visitDtoSet.add(VisitMapper.map(visit))));

        return visitDtoSet;
    }
}
