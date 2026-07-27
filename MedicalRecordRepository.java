package com.poojitha.healthcare.repository;

import com.poojitha.healthcare.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MedicalRecordRepository {

    private final ConcurrentHashMap<Long, Patient> database =
            new ConcurrentHashMap<>();

    public Patient save(Patient patient) {

        database.put(
                patient.getPatientId(),
                patient
        );

        return patient;
    }

    public Optional<Patient> findById(Long patientId) {

        return Optional.ofNullable(
                database.get(patientId)
        );

    }

    public List<Patient> findAll() {

        return new ArrayList<>(database.values());

    }

    public void delete(Long patientId) {

        database.remove(patientId);

    }

    public long totalPatients() {

        return database.size();

    }

    public long admittedPatients() {

        return database.values()
                .stream()
                .filter(Patient::isAdmitted)
                .count();

    }

    public Optional<Patient> oldestPatient() {

        return database.values()
                .stream()
                .max(Comparator.comparingInt(
                        Patient::getAge));

    }

    public List<Patient> patientsByDoctor(
            String doctorName) {

        return database.values()
                .stream()
                .filter(patient ->
                        patient.getDoctorName()
                                .equalsIgnoreCase(doctorName))
                .toList();

    }

}
