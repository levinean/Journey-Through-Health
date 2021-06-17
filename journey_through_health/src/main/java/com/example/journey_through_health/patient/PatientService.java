package com.example.journey_through_health.patient;

import com.example.journey_through_health.JourneyCrud;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements JourneyCrud<Patient> {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient edit(Long id, Patient o) {
        return null;
    }

    @Override
    public Optional<Patient> get(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Optional<Patient> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Patient> listAll() {
        return patientRepository.findAll();
    }
}
