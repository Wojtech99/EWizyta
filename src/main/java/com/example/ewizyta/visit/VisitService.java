package com.example.ewizyta.visit;

import com.example.ewizyta.doctor.DoctorDto;
import com.example.ewizyta.patient.PatientDto;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


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
        return visitRepository.findAllByPatient_Id(patientDto.getId()).stream()
                .map(VisitMapper::map)
                .collect(Collectors.toSet());
    }

    public void deleteVisit(VisitDto visitDto) {
        visitRepository.deleteById(visitDto.getId());
    }

    public Set<VisitDto> allPastDoctorsVisits(DoctorDto doctorDto) {
        return visitRepository.findAllByDoctor_Id(doctorDto.getId()).stream()
                .map(VisitMapper::map)
                .collect(Collectors.toSet());
    }
}
