package com.example.journey_through_health.patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    void createPatient(Patient patient);
    Optional<Patient> getPatient(Long id);
    List<Patient> getPatients();
}
