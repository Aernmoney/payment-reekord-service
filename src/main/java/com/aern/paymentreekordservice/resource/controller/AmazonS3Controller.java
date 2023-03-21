package com.aern.paymentreekordservice.resource.controller;

import com.aern.paymentreekordservice.model.KycDetail;
import com.aern.paymentreekordservice.resource.api.AmazonS3Api;
import com.aern.paymentreekordservice.service.S3Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AmazonS3Controller implements AmazonS3Api {

    private final S3Service s3Service;

    public AmazonS3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @Override
    public ResponseEntity<KycDetail> uploadFile(String phoneNumber, MultipartFile multipartFile, String key) {
        KycDetail response = s3Service.uploadFileToS3Bucket(key,phoneNumber,multipartFile);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
