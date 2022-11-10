package com.example.ewizyta.visit;

public class VisitMapper {
    static VisitDto map(Visit visit) {
        return new VisitDto(
                visit.getId(),
                visit.getIllness(),
                visit.getDescription(),
                visit.getPrescription(),
                visit.getPatient(),
                visit.getDoctor()
        );
    }

    static Visit map(VisitDto visitDto) {
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
