package com.example.ewizyta.Security;

import com.example.ewizyta.doctor.Doctor;
import com.example.ewizyta.patient.Patient;

public class UserCredentialsDtoMapper {
    static UserCredentialsDto map(Patient user){
        return new UserCredentialsDto(
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    static UserCredentialsDto map(Doctor user){
        return new UserCredentialsDto(
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }
}
