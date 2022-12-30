package com.example.ewizyta.visit;

import com.example.ewizyta.visit.VisitDtos.VisitDto;
import com.example.ewizyta.visit.VisitMappers.VisitMapper;
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

    public Optional<VisitDto> takeVisit(Long id) {
        return visitRepository.findById(id)
                .map(VisitMapper::map);
    }

    public VisitDto saveVisit(VisitDto visitDto) {
        Visit visitToSave = VisitMapper.map(visitDto);
        Visit savedVisit = visitRepository.save(visitToSave);

        return VisitMapper.map(savedVisit);
    }

    public Set<VisitDto> pastAllPatientsVisits(Long patientId) {
        return visitRepository.findAllByPatient_Id(patientId).stream()
                .map(VisitMapper::map)
                .collect(Collectors.toSet());

    }

    public void deleteVisit(Long visitId) {
        visitRepository.deleteById(visitId);
    }

    public Set<VisitDto> allPastDoctorsVisits(Long doctorId) {
        Set<VisitDto> visitDtoSet = new HashSet<>();

        visitRepository.findAllByDoctor_Id(doctorId).ifPresent(visits ->
                visits.forEach(visit->
                        visitDtoSet.add(VisitMapper.map(visit))));

        return visitDtoSet;
    }
}
