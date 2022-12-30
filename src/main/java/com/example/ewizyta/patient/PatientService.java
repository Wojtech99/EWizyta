package com.example.ewizyta.patient;

import com.example.ewizyta.role.Role;
import com.example.ewizyta.role.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public PatientService(PatientRepository patientRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Transactional
    void registerNewPatient(PatientDto patientDto) {
        String hashPassword = passwordEncoder.encode(patientDto.getPassword());
        Role role = roleRepository.getRoleByName("PATIENT");
        patientDto.setPassword(hashPassword);

        Patient patientToSave = PatientMapper.map(patientDto);
        patientToSave.setRole(role);

        patientRepository.save(patientToSave);
    }

    public Patient getCurrentLoggedPatient(String email) {
        return patientRepository.getPatientsByEmail(email);
    }

    public Patient findPatientByPersonalId(Integer patientPersonalId) throws NullPointerException{
        if (patientRepository.findPatientByPersonalId(patientPersonalId).isEmpty())  {
            return null;
        }
        return patientRepository.findPatientByPersonalId(patientPersonalId).get();
    }
}
