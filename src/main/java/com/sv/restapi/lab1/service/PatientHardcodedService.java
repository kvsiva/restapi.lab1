package com.sv.restapi.lab1.service;

import com.sv.restapi.lab1.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientHardcodedService {

    private static List<Patient> patients = new ArrayList<>();
    private static long idCounter = 0;
    static {
        patients.add(new Patient(++idCounter, "svcs", "Ramana K"));
        patients.add(new Patient(++idCounter, "svcs", "Rajesh S"));
        patients.add(new Patient(++idCounter, "svcs", "Balaji P"));
        patients.add(new Patient(++idCounter, "svcs",
                "Srinath T"));
    }
    public List<Patient> findAll() {
        return patients;
    }

//    public Course findById(int id) {
//        return courses.get(id);
//    }

    public Patient findById(long id) {
        for (Patient course: patients) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public Patient deleteById(Long id) {
        Patient course = findById(id);
        if (course == null)
            return null;
        if (patients.remove(course)) {
            return course;
        }
        return null;
    }

    public Patient save(Patient patient) {
        if (patient.getId() == -1 || patient.getId() == 0) {
            patient.setId(++idCounter);
            patients.add(patient);
        } else {
            deleteById(patient.getId());
            patients.add(patient);
        }
        return patient;
    }
}
