package com.poojitha.healthcare.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AwsS3StorageService {

    private final Map<String, String> s3Bucket =
            new HashMap<>();

    @Async
    public String uploadMedicalImage(String patientNumber,
                                     String imageName) {

        String objectKey =
                patientNumber +
                "/" +
                UUID.randomUUID() +
                "_" +
                imageName;

        s3Bucket.put(
                objectKey,
                "ENCRYPTED_IMAGE_DATA"
        );

        System.out.println("Uploading Image to AWS S3");
        System.out.println("Object Key : " + objectKey);
        System.out.println("Uploaded At : " + LocalDateTime.now());

        return objectKey;
    }

    public String downloadMedicalImage(String objectKey) {

        return s3Bucket.getOrDefault(
                objectKey,
                "Image Not Found"
        );
    }

    public boolean deleteMedicalImage(String objectKey) {

        return s3Bucket.remove(objectKey) != null;
    }

    public long totalStoredImages() {

        return s3Bucket.size();
    }

}
