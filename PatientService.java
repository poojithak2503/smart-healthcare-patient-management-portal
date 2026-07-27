package com.poojitha.healthcare.service;

import com.poojitha.healthcare.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final List<Patient> patients =
            new ArrayList<>();

    public Patient registerPatient(Patient patient) {

        patients.add(patient);

        return patient;
    }

    public Optional<Patient> findPatient(Long patientId) {

        return patients.stream()
                .filter(patient ->
                        patient.getPatientId().equals(patientId))
                .findFirst();
    }

    public List<Patient> getAllPatients() {

        return new ArrayList<>(patients);

    }

    public void admitPatient(Long patientId) {

        findPatient(patientId)
                .ifPresent(Patient::admitPatient);

    }

    public void dischargePatient(Long patientId) {

        findPatient(patientId)
                .ifPresent(Patient::dischargePatient);

    }

    public void updatePrescription(Long patientId,
                                   String prescription) {

        findPatient(patientId)
                .ifPresent(patient ->
                        patient.setPrescription(prescription));

    }

    public long admittedPatients() {

        return patients.stream()
                .filter(Patient::isAdmitted)
                .count();

    }

    public long dischargedPatients() {

        return patients.size() -
                admittedPatients();

    }

    public Optional<Patient> oldestPatient() {

        return patients.stream()
                .max(Comparator.comparingInt(
                        Patient::getAge));

    }

    public String patientSummaryReport() {

        StringBuilder report =
                new StringBuilder();

        report.append("Healthcare Patient Summary\n");
        report.append("---------------------------------\n");
        report.append("Generated : ")
                .append(LocalDateTime.now())
                .append("\n");

        report.append("Registered Patients : ")
                .append(patients.size())
                .append("\n");

        report.append("Admitted Patients : ")
                .append(admittedPatients())
                .append("\n");

        report.append("Discharged Patients : ")
                .append(dischargedPatients())
                .append("\n");

        oldestPatient().ifPresent(patient ->
                report.append("Oldest Patient : ")
                        .append(patient.getFirstName())
                        .append(" ")
                        .append(patient.getLastName())
                        .append("\n"));

        return report;
    }

}
