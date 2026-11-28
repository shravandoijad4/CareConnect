package com.careconnect.patient_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careconnect.patient_service.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByEmail(String email);

    boolean existsByEmail(String email);
}