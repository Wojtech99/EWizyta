package com.example.ewizyta.visit.VisitMappers;

import com.example.ewizyta.visit.Visit;
import com.example.ewizyta.visit.VisitDtos.VisitDto;
import com.example.ewizyta.visit.VisitDtos.VisitDtoThymeleaf;

public class VisitDtoThymeleafMapper {
    public static VisitDtoThymeleaf map(VisitDto visitDto) {
        return new VisitDtoThymeleaf(
                visitDto.getId(),
                visitDto.getIllness(),
                visitDto.getDescription(),
                visitDto.getPrescription(),
                visitDto.getPatient().getName() + " " + visitDto.getPatient().getLastName(),
                visitDto.getPatient().getEmail(),
                visitDto.getPatient().getPersonalId(),
                visitDto.getDoctor().getName() + " " + visitDto.getDoctor().getLastName(),
                visitDto.getDoctor().getSpecialization().getDescription()
        );
    }

    public static VisitDtoThymeleaf map(Visit visit) {
        return new VisitDtoThymeleaf(
                visit.getId(),
                visit.getIllness(),
                visit.getDescription(),
                visit.getPrescription(),
                visit.getPatient().getName() + " " + visit.getPatient().getLastName(),
                visit.getPatient().getEmail(),
                visit.getPatient().getPersonalId(),
                visit.getDoctor().getName() + " " + visit.getDoctor().getLastName(),
                visit.getDoctor().getSpecialization().name()
        );
    }
}
