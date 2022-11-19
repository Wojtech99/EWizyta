package com.example.ewizyta.visit;

import com.example.ewizyta.doctor.DoctorDto;
import com.example.ewizyta.patient.PatientDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
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

    public Optional<Set<VisitDto>> pastAllPatientsVisits(PatientDto patientDto) {
        Set<VisitDto> visitDtoSet = new HashSet<>();

        visitRepository.findAllByPatient_Id(patientDto.getId()).stream()
                .forEach(visits -> visits.forEach(visit->
                        visitDtoSet.add(VisitMapper.map(visit))));

        return Optional.of(visitDtoSet);

    }

    public void deleteVisit(VisitDto visitDto) {
        visitRepository.deleteById(visitDto.getId());
    }

    public Optional<Set<VisitDto>> allPastDoctorsVisits(DoctorDto doctorDto) {
        Set<VisitDto> visitDtoSet = new HashSet<>();

        visitRepository.findAllByPatient_Id(doctorDto.getId()).stream()
                .forEach(visits -> visits.forEach(visit->
                        visitDtoSet.add(VisitMapper.map(visit))));

        return Optional.of(visitDtoSet);
    }
}
