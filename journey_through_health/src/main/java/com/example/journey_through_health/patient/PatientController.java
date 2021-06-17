package com.example.journey_through_health.patient;

import com.example.journey_through_health.event.Event;
import com.example.journey_through_health.event.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/patients")
public class PatientController {
    private final EventService eventService;
    private final PatientService patientService;

    public PatientController(PatientService patientService, EventService eventService) {
        this.patientService = patientService;
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        Optional<Patient> patientData = patientService.get(id);

        return patientData
                .map(patient -> new ResponseEntity<>(patient, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        patientService.create(patient);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/events")
    public ResponseEntity<Event> createEvent(@PathVariable (value = "id") Long id,
                             @RequestBody Event event) {
        Optional<Patient> patientData = patientService.get(id);
        if (patientData.isPresent()) {
            event.setPatient(patientData.get());
            eventService.create(event);
            return new ResponseEntity<>(event, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
