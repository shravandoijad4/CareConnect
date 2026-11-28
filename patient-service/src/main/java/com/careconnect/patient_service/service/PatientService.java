package com.careconnect.patient_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.careconnect.patient_service.model.Patient;
import com.careconnect.patient_service.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient create(Patient patient) {
        if (patientRepository.existsByEmail(patient.getEmail())) {
            throw new IllegalArgumentException("Email already registered: " + patient.getEmail());
        }
        return patientRepository.save(patient);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient getById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    public Patient update(Long id, Patient updated) {
        Patient existing = getById(id);
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setPhone(updated.getPhone());
        existing.setDateOfBirth(updated.getDateOfBirth());
        existing.setGender(updated.getGender());
        existing.setBloodGroup(updated.getBloodGroup());
        return patientRepository.save(existing);
    }

    public void delete(Long id) {
        getById(id);
        patientRepository.deleteById(id);
    }
}