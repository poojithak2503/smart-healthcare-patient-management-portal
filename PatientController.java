package com.poojitha.healthcare.controller;

import com.poojitha.healthcare.model.Patient;
import com.poojitha.healthcare.service.PatientService;
import com.poojitha.healthcare.service.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;
    private final PrescriptionService prescriptionService;

    public PatientController(PatientService patientService,
                             PrescriptionService prescriptionService) {
        this.patientService = patientService;
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/register")
    public Patient registerPatient(@RequestBody Patient patient) {

        return patientService.registerPatient(patient);

    }

    @GetMapping
    public List<Patient> getAllPatients() {

        return patientService.getAllPatients();

    }

    @GetMapping("/{patientId}")
    public Optional<Patient> getPatient(
            @PathVariable Long patientId) {

        return patientService.findPatient(patientId);

    }

    @PutMapping("/{patientId}/admit")
    public String admitPatient(
            @PathVariable Long patientId) {

        patientService.admitPatient(patientId);

        return "Patient admitted successfully.";

    }

    @PutMapping("/{patientId}/discharge")
    public String dischargePatient(
            @PathVariable Long patientId) {

        patientService.dischargePatient(patientId);

        return "Patient discharged successfully.";

    }

    @PutMapping("/{patientId}/prescription")
    public String updatePrescription(
            @PathVariable Long patientId,
            @RequestParam String prescription) {

        prescriptionService.updatePrescription(
                patientId,
                prescription
        );

        return "Prescription updated successfully.";

    }

    @GetMapping("/report")
    public String report() {

        return patientService.patientSummaryReport();

    }

}
