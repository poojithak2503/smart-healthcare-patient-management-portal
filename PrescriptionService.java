package com.poojitha.healthcare.service;

import com.poojitha.healthcare.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PrescriptionService {

    private final PatientService patientService;

    public PrescriptionService(PatientService patientService) {
        this.patientService = patientService;
    }

    public void updatePrescription(Long patientId,
                                   String prescription) {

        patientService.updatePrescription(
                patientId,
                prescription
        );

        System.out.println("Prescription Updated");
        System.out.println("Patient Id : " + patientId);
        System.out.println("Time : " + LocalDateTime.now());

    }

    public Optional<String> getPrescription(Long patientId) {

        return patientService.findPatient(patientId)
                .map(Patient::getPrescription);

    }

    public boolean validatePrescription(String prescription) {

        return prescription != null
                && !prescription.isBlank()
                && prescription.length() >= 5;

    }

    public String generatePrescriptionNumber(Long patientId) {

        return "RX-"
                + patientId
                + "-"
                + System.currentTimeMillis();

    }

    public boolean containsControlledMedicine(
            String prescription) {

        if (prescription == null) {
            return false;
        }

        String text = prescription.toUpperCase();

        return text.contains("MORPHINE")
                || text.contains("OXYCODONE")
                || text.contains("FENTANYL");
    }

}
