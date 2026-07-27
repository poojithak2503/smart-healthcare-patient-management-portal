package com.poojitha.healthcare.service;

import com.poojitha.healthcare.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PatientServiceTest {

    private PatientService patientService;

    @BeforeEach
    void setup() {

        patientService = Mockito.spy(
                new PatientService());

    }

    @Test
    void shouldRegisterPatient() {

        Patient patient =
                new Patient(
                        1L,
                        "PAT1001",
                        "John",
                        "Smith",
                        32,
                        "Male",
                        "O+",
                        "9999999999",
                        "john@test.com",
                        "New York",
                        "Fever",
                        "Paracetamol",
                        "Dr. Wilson"
                );

        patientService.registerPatient(patient);

        Assertions.assertEquals(
                1,
                patientService.getAllPatients().size());
    }

    @Test
    void shouldAdmitPatient() {

        Patient patient =
                new Patient(
                        2L,
                        "PAT1002",
                        "Alice",
                        "Brown",
                        45,
                        "Female",
                        "A+",
                        "8888888888",
                        "alice@test.com",
                        "Chicago",
                        "Diabetes",
                        "Insulin",
                        "Dr. James"
                );

        patientService.registerPatient(patient);

        patientService.admitPatient(2L);

        Assertions.assertTrue(
                patientService.findPatient(2L)
                        .get()
                        .isAdmitted());
    }

    @Test
    void shouldUpdatePrescription() {

        Patient patient =
                new Patient(
                        3L,
                        "PAT1003",
                        "David",
                        "Clark",
                        50,
                        "Male",
                        "B+",
                        "7777777777",
                        "david@test.com",
                        "Dallas",
                        "Hypertension",
                        "Tablet",
                        "Dr. Adams"
                );

        patientService.registerPatient(patient);

        patientService.updatePrescription(
                3L,
                "Blood Pressure Medicine");

        Assertions.assertEquals(
                "Blood Pressure Medicine",
                patientService.findPatient(3L)
                        .get()
                        .getPrescription());
    }

    @Test
    void shouldGeneratePatientReport() {

        Mockito.doCallRealMethod()
                .when(patientService)
                .patientSummaryReport();

        Assertions.assertNotNull(
                patientService.patientSummaryReport());
    }

}
