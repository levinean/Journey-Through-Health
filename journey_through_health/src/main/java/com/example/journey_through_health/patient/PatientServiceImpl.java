package com.example.journey_through_health.patient;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> getPatient(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }
}
