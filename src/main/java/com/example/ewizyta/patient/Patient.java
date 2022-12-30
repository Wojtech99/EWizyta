package com.example.ewizyta.patient;

import com.example.ewizyta.role.Role;
import com.example.ewizyta.visit.Visit;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Integer personalId;
    private String email;
    private String password;
    private Date birthDate;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(mappedBy = "patient")
    private Set<Visit> pastVisits = new HashSet<>();

    public Patient(String name, String lastName, Integer personalId,
                   String email, String password, Date birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.personalId = personalId;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public Patient(){}

    public Long getId() {
        return id;
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

    public void setPastVisits(Set<Visit> pastVisits) {
        this.pastVisits = pastVisits;
    }

    public Set<Visit> getPastVisits() {
        return pastVisits;
    }


}
