package com.example.journey_through_health.patient;

import com.example.journey_through_health.event.Event;
import com.example.journey_through_health.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private EventService eventService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        Optional<Patient> patientData = patientService.getPatient(id);

        return patientData
                .map(patient -> new ResponseEntity<>(patient, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        patientService.createPatient(patient);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/events")
    public ResponseEntity<Object> createEvent(@PathVariable (value = "id") Long id,
                             @RequestBody Event event) {
        Optional<Patient> patientData = patientService.getPatient(id);
        if (patientData.isPresent()) {
            event.setPatient(patientData.get());
            eventService.createEvent(event);
            return new ResponseEntity<>("Event is created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
        }
    }

}
