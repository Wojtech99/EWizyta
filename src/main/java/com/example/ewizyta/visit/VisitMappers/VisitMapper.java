package com.example.ewizyta.visit.VisitMappers;

import com.example.ewizyta.visit.Visit;
import com.example.ewizyta.visit.VisitDtos.VisitDto;

public class VisitMapper {
    public static VisitDto map(Visit visit) {
        return new VisitDto(
                visit.getId(),
                visit.getIllness(),
                visit.getDescription(),
                visit.getPrescription(),
                visit.getPatient(),
                visit.getDoctor()
        );
    }

    public static Visit map(VisitDto visitDto) {
        Visit visit = new Visit(
                visitDto.getIllness(),
                visitDto.getDescription(),
                visitDto.getPrescription()
        );

        visit.setPatient(visitDto.getPatient());
        visit.setDoctor(visitDto.getDoctor());

        return visit;
    }
}
