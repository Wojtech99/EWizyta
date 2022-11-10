package com.example.ewizyta.doctor;

import com.example.ewizyta.role.Role;
import com.example.ewizyta.patient.Patient;
import com.example.ewizyta.visit.Visit;

import javax.persistence.*;
import java.util.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(mappedBy = "doctor")
    private Set<Visit> pastVisits = new HashSet<>();
    @OneToMany
    @JoinColumn(name = "patientList")
    private List<Patient> patientQueue = new LinkedList<>();

    public Doctor() {}

    public Doctor(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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
}
