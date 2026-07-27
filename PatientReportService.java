package com.poojitha.healthcare.service;

import com.poojitha.healthcare.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientReportService {

    private final PatientService patientService;

    public PatientReportService(PatientService patientService) {
        this.patientService = patientService;
    }

    public Map<String, Object> dashboardReport() {

        List<Patient> patients =
                patientService.getAllPatients();

        Map<String, Object> report =
                new HashMap<>();

        report.put(
                "Total Patients",
                patients.size());

        report.put(
                "Admitted Patients",
                patients.stream()
                        .filter(Patient::isAdmitted)
                        .count());

        report.put(
                "Discharged Patients",
                patients.stream()
                        .filter(patient -> !patient.isAdmitted())
                        .count());

        report.put(
                "Adult Patients",
                patients.stream()
                        .filter(Patient::isAdult)
                        .count());

        report.put(
                "Stored Medical Images",
                patients.stream()
                        .filter(patient ->
                                patient.getMedicalImageUrl() != null)
                        .count());

        return report;
    }

    public double admissionRate() {

        List<Patient> patients =
                patientService.getAllPatients();

        if (patients.isEmpty()) {
            return 0;
        }

        return patientService.admittedPatients()
                * 100.0
                / patients.size();
    }

}
