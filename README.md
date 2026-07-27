# Smart Healthcare Patient Management Portal

## Overview

The Smart Healthcare Patient Management Portal is a secure web-based healthcare application that enables hospitals and clinics to manage patient records, prescriptions, admissions, and encrypted medical images through a centralized platform. The application is built using Spring Boot and Spring MVC with a layered architecture and integrates AWS S3 for secure medical image storage. The backend exposes REST APIs that can be consumed by a Thymeleaf-based user interface for doctors, nurses, and hospital administrators.

The project demonstrates enterprise healthcare application development using Java, Spring MVC, AWS cloud services, secure document storage, JUnit, Mockito, and modern software engineering practices.

---

# Features

- Patient Registration
- Patient Profile Management
- Admission & Discharge Management
- Electronic Medical Records (EMR)
- Prescription Management
- Doctor-wise Patient Tracking
- Secure Medical Image Storage
- AWS S3 Integration
- Medical Report Generation
- RESTful APIs
- Unit Testing
- Mockito Mock Testing

---

# Technology Stack

| Technology | Version |
|------------|----------|
| Java | 11 |
| Spring Boot | 2.x |
| Spring MVC | Latest |
| Thymeleaf | Latest |
| AWS S3 | Latest |
| JUnit 5 | Latest |
| Mockito | Latest |
| Maven | 3.x |

---

# Project Structure

```
smart-healthcare-patient-management-portal
│
├── controller
│     PatientController.java
│
├── model
│     Patient.java
│
├── repository
│     MedicalRecordRepository.java
│
├── service
│     PatientService.java
│     PrescriptionService.java
│     AwsS3StorageService.java
│     MedicalImageService.java
│     PatientReportService.java
│
├── test
│     PatientServiceTest.java
│
└── PatientManagementApplication.java
```

---

# System Architecture

```
                Hospital Staff

                     │

                     ▼

              Thymeleaf Portal

                     │

                     ▼

            PatientController

                     │

        ┌────────────┼─────────────┐
        │            │             │

        ▼            ▼             ▼

PatientService  Prescription   MedicalImage
                  Service         Service

        │            │             │
        │            │             ▼
        │            │      AwsS3StorageService
        │            │             │
        ▼            ▼             ▼

 MedicalRecordRepository       AWS S3 Bucket

        │
        ▼

     Database
```

---

# Patient Registration Workflow

```
Hospital Staff

      │

      ▼

Register Patient

      │

      ▼

Validate Details

      │

      ▼

Generate Patient Number

      │

      ▼

Store Medical Record

      │

      ▼

Registration Completed
```

---

# Medical Image Upload Workflow

```
Doctor

   │

   ▼

Select Patient

   │

   ▼

Upload Medical Image

   │

   ▼

Encrypt Image

   │

   ▼

Upload to AWS S3

   │

   ▼

Store Object Key

   │

   ▼

Medical Record Updated
```

---

# Prescription Workflow

```
Doctor

    │

    ▼

Patient Consultation

    │

    ▼

Diagnosis

    │

    ▼

Prescription Creation

    │

    ▼

Prescription Validation

    │

    ▼

Medical Record Updated
```

---

# REST APIs

## Register Patient

```
POST /api/patients/register
```

Example Request

```json
{
  "patientId":101,
  "patientNumber":"PAT1001",
  "firstName":"John",
  "lastName":"Smith",
  "age":34,
  "gender":"Male",
  "bloodGroup":"O+",
  "phoneNumber":"9999999999",
  "email":"john@test.com",
  "address":"New York",
  "diagnosis":"Fever",
  "prescription":"Paracetamol",
  "doctorName":"Dr. Wilson"
}
```

---

## Get All Patients

```
GET /api/patients
```

---

## Get Patient

```
GET /api/patients/{patientId}
```

---

## Admit Patient

```
PUT /api/patients/{patientId}/admit
```

---

## Discharge Patient

```
PUT /api/patients/{patientId}/discharge
```

---

## Update Prescription

```
PUT /api/patients/{patientId}/prescription
```

---

## Patient Summary Report

```
GET /api/patients/report
```

---

# Dashboard Metrics

The hospital dashboard displays:

- Total Registered Patients
- Admitted Patients
- Discharged Patients
- Adult Patients
- Medical Images Stored
- Doctor-wise Patient Count
- Latest Admissions
- Prescription Updates
- Daily Registrations
- Hospital Statistics

---

# Business Components

## PatientController

Handles REST endpoints for patient registration, admission, discharge, prescriptions, and reports.

---

## PatientService

Manages patient registration, admission/discharge workflow, patient lookup, and business rules.

---

## PrescriptionService

Creates, validates, updates, and manages electronic prescriptions while detecting controlled medications.

---

## MedicalRecordRepository

Stores and retrieves patient medical records using the repository pattern.

---

## AwsS3StorageService

Uploads encrypted medical images to private AWS S3 buckets and manages secure retrieval and deletion.

---

## MedicalImageService

Associates medical images with patient records and coordinates secure image storage.

---

## PatientReportService

Generates hospital dashboard statistics, patient analytics, and admission reports.

---

## PatientServiceTest

Implements unit testing using JUnit 5 and Mockito to validate patient workflows and improve code quality.

---

# Sample Hospital Dashboard

```
Hospital Dashboard

-------------------------------------

Registered Patients : 350

Admitted Patients : 96

Discharged Patients : 254

Medical Images Stored : 610

Doctors : 24

Today's Admissions : 18

Average Admission Rate : 27.4%

Generated : 2026-07-27 10:30 AM
```

---

# Sample Patient Record

```
Patient Number : PAT1001

Patient Name : John Smith

Doctor : Dr. Wilson

Diagnosis : Viral Fever

Prescription : Paracetamol 650 mg

Blood Group : O+

Admission Status : Admitted

Medical Image : s3://private-medical-bucket/PAT1001/xray001.png
```

---

# Testing Strategy

The application includes unit testing for:

- Patient Registration
- Admission Workflow
- Discharge Workflow
- Prescription Updates
- Medical Image Upload
- Report Generation
- Repository Operations
- Edge Case Validation
- Null Input Handling
- Invalid Patient Requests

Testing tools:

- JUnit 5
- Mockito
- Mock Objects
- Assertions
- Service Layer Testing

---

# Enterprise Concepts Demonstrated

- Spring Boot
- Spring MVC
- Layered Architecture
- Repository Pattern
- REST API Development
- AWS S3 Integration
- Secure Medical Image Storage
- Electronic Medical Records
- Healthcare Workflow Management
- Dependency Injection
- Object-Oriented Programming
- Unit Testing
- Mockito Mocking
- Exception Handling

---

# Future Enhancements

- Spring Security
- JWT Authentication
- OAuth2 Integration
- Role-Based Access Control
- MySQL Database Integration
- Spring Data JPA
- AWS RDS
- AWS CloudWatch
- AWS Lambda
- Docker
- Kubernetes
- Redis Cache
- Appointment Scheduling
- SMS Notifications
- Email Notifications
- PDF Medical Reports
- Swagger/OpenAPI
- CI/CD with Jenkins
- SonarQube
- HL7/FHIR Healthcare Integration

---

# Learning Outcomes

This project demonstrates practical implementation of:

- Java Enterprise Development
- Spring MVC Architecture
- Spring Boot REST APIs
- AWS S3 File Storage
- Patient Management Systems
- Electronic Medical Records
- Secure Healthcare Applications
- Medical Image Management
- Unit Testing with JUnit
- Mock Testing with Mockito
- Enterprise Layered Architecture
- Healthcare Domain Design

---

## Author

**Poojitha Kanuri**

Java Full Stack Developer

Email: poojithakanuri03@gmail.com

LinkedIn: https://linkedin.com/in/poojithakanuri

GitHub: https://github.com/poojithak2503
