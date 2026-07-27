package com.poojitha.healthcare.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Patient {

    private Long patientId;
    private String patientNumber;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String bloodGroup;
    private String phoneNumber;
    private String email;
    private String address;
    private String diagnosis;
    private String prescription;
    private String doctorName;
    private String medicalImageUrl;
    private boolean admitted;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private LocalDateTime createdDate;

    public Patient() {
    }

    public Patient(Long patientId,
                   String patientNumber,
                   String firstName,
                   String lastName,
                   int age,
                   String gender,
                   String bloodGroup,
                   String phoneNumber,
                   String email,
                   String address,
                   String diagnosis,
                   String prescription,
                   String doctorName) {

        this.patientId = patientId;
        this.patientNumber = patientNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.doctorName = doctorName;
        this.createdDate = LocalDateTime.now();
        this.admitted = false;
    }

    public void admitPatient() {

        admitted = true;
        admissionDate = LocalDate.now();

    }

    public void dischargePatient() {

        admitted = false;
        dischargeDate = LocalDate.now();

    }

    public boolean isAdult() {

        return age >= 18;

    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getMedicalImageUrl() {
        return medicalImageUrl;
    }

    public void setMedicalImageUrl(String medicalImageUrl) {
        this.medicalImageUrl = medicalImageUrl;
    }

    public boolean isAdmitted() {
        return admitted;
    }

    public void setAdmitted(boolean admitted) {
        this.admitted = admitted;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof Patient)) {
            return false;
        }

        Patient patient = (Patient) object;

        return Objects.equals(patientId, patient.patientId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(patientId);

    }

    @Override
    public String toString() {

        return "Patient{" +
                "patientId=" + patientId +
                ", patientNumber='" + patientNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", admitted=" + admitted +
                '}';

    }

}
