package com.example.ewizyta.patient;

import com.example.ewizyta.role.Role;
import com.example.ewizyta.visit.Visit;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

public class PatientDto {
    private Long id;
    private String name;
    private String lastName;
    private Integer personalId;
    private String email;
    private String password;
    private Date birthDate;
    private Role role;
    private Set<Visit> pastVisits;

    public PatientDto(Long id, String name, String lastName, Integer personalId,
                      String email, String password, Date birthDate, Role role, Set<Visit> pastVisits) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.personalId = personalId;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.role = role;
        this.pastVisits = pastVisits;
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

    public Integer getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Integer personalId) {
        this.personalId = personalId;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDto that = (PatientDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(personalId, that.personalId) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(birthDate, that.birthDate) && Objects.equals(role, that.role) && Objects.equals(pastVisits, that.pastVisits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, personalId, email, password, birthDate, role, pastVisits);
    }
}
