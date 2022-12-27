package com.example.ewizyta.Security;

import com.example.ewizyta.doctor.DoctorRepository;
import com.example.ewizyta.patient.PatientRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public CustomUserDetailsService(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getAllUsers().stream()
                .filter(user -> username.equals(user.getEmail()))
                .findFirst()
                .map(this::createUserDetails)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("user with email \"%s\" not found", username)));
    }

    private UserDetails createUserDetails(UserCredentialsDto credentials) {
        return User.builder()
                .username(credentials.getEmail())
                .password(credentials.getPassword())
                .roles(credentials.getRole().getName())
                .build();
    }

    private Set<UserCredentialsDto> getAllUsers(){
        Set<UserCredentialsDto> usersSet = new HashSet<>();

        patientRepository.getAll().stream().forEach(patient ->
                usersSet.add(UserCredentialsDtoMapper.map(patient)));

        doctorRepository.getAll().stream().forEach(doctor ->
                usersSet.add(UserCredentialsDtoMapper.map(doctor)));

        return usersSet;
    }
}
