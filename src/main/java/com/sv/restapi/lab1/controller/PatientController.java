package com.sv.restapi.lab1.controller;

import com.sv.restapi.lab1.entity.Patient;
import com.sv.restapi.lab1.service.PatientHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class PatientController {

    @Autowired
    private PatientHardcodedService patientHardcodedService;
    @GetMapping("/hospital/{username}/patients")
    public List<Patient> getAllPatients(@PathVariable String username) {
        return patientHardcodedService.findAll();
    }

    @DeleteMapping("/hospital/{username}/patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String username, @PathVariable long id) {
        Patient patient = patientHardcodedService.deleteById(id);
        if (patient != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/hospital/{username}/patients/{id}")
    public Patient getPatient(@PathVariable String username, @PathVariable long id) {
        return patientHardcodedService.findById(id);
    }

    @PutMapping("/hospital/{username}/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String username, @PathVariable long id,
                                               @RequestBody Patient course) {
        Patient courseUpdated = patientHardcodedService.save(course);
        return new ResponseEntity<Patient>(courseUpdated, HttpStatus.OK);
    }

    @PostMapping("/hospital/{username}/patients")
    public ResponseEntity<Void> createPatient(@PathVariable String username, @RequestBody Patient patient) {
        Patient createdPatient = patientHardcodedService.save(patient);
        // Location
        // Get current resource url
        /// {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPatient.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
