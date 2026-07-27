package com.poojitha.healthcare.service;

import com.poojitha.healthcare.model.Patient;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalImageService {

    private final PatientService patientService;
    private final AwsS3StorageService storageService;

    public MedicalImageService(PatientService patientService,
                               AwsS3StorageService storageService) {
        this.patientService = patientService;
        this.storageService = storageService;
    }

    public String uploadPatientImage(Long patientId,
                                     String imageName) {

        Optional<Patient> patient =
                patientService.findPatient(patientId);

        if (patient.isEmpty()) {
            return "Patient Not Found";
        }

        String objectKey =
                storageService.uploadMedicalImage(
                        patient.get().getPatientNumber(),
                        imageName);

        patient.get().setMedicalImageUrl(objectKey);

        return objectKey;
    }

    public String viewMedicalImage(Long patientId) {

        Optional<Patient> patient =
                patientService.findPatient(patientId);

        if (patient.isEmpty()) {
            return "Patient Not Found";
        }

        return storageService.downloadMedicalImage(
                patient.get().getMedicalImageUrl());
    }

    public boolean removeMedicalImage(Long patientId) {

        Optional<Patient> patient =
                patientService.findPatient(patientId);

        if (patient.isEmpty()) {
            return false;
        }

        return storageService.deleteMedicalImage(
                patient.get().getMedicalImageUrl());
    }

}
