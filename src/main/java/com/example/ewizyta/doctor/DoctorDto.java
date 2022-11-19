package com.example.ewizyta.doctor;

import com.example.ewizyta.patient.Patient;
import com.example.ewizyta.role.Role;
import com.example.ewizyta.visit.Visit;

import java.util.*;

public class DoctorDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Specialization specialization;
    private Role role;
    private Set<Visit> pastVisits;
    private List<Patient> patientQueue;

    public DoctorDto(Long id, String name, String lastName, String email,
                     String password, Role role, Set<Visit> pastVisits,
                     List<Patient> patientQueue, Specialization specialization) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.pastVisits = pastVisits;
        this.patientQueue = patientQueue;
        this.specialization = specialization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Visit> getPastVisits() {
        return pastVisits;
    }

    public void setPastVisits(Set<Visit> pastVisits) {
        this.pastVisits = pastVisits;
    }

    public List<Patient> getPatientQueue() {
        return patientQueue;
    }

    public void setPatientQueue(List<Patient> patientQueue) {
        this.patientQueue = patientQueue;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public void addVisit(Visit visit) {
        this.pastVisits.add(visit);
    }

    public void deleteVisit(Visit visit){
        this.pastVisits.remove(visit);
    }

    public void addPatientToQueue(Patient patient){
        this.patientQueue.add(patient);
    }

    public void removePatientFromQueue(Patient patient) {
        this.patientQueue.remove(patient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorDto doctorDto = (DoctorDto) o;
        return Objects.equals(id, doctorDto.id) && Objects.equals(name, doctorDto.name) && Objects.equals(lastName, doctorDto.lastName) && Objects.equals(email, doctorDto.email) && Objects.equals(password, doctorDto.password) && Objects.equals(role, doctorDto.role) && Objects.equals(pastVisits, doctorDto.pastVisits) && Objects.equals(patientQueue, doctorDto.patientQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, email, password, role, pastVisits, patientQueue);
    }
}
