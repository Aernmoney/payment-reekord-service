package com.aern.paymentreekordservice.service;

import com.aern.paymentreekordservice.model.KycDetail;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class S3Service {

    private final static String BUCKET_NAME = "reekords";

    private final AmazonS3Client amazonS3Client;

    public S3Service(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    public KycDetail uploadFileToS3Bucket(String key , String phoneNumber, MultipartFile file) {
        /* unique file Name */
        String fileName = phoneNumber+"_"+key+"_"+file.getOriginalFilename();
        /* converting multipartfile to file*/
        File file1 = convertMultiParttoFile(file);
        String fileUrl = "https://"+BUCKET_NAME+"."+"s3-ap-south-1.amazonaws.com/"+fileName;
        amazonS3Client.putObject(new PutObjectRequest(BUCKET_NAME,fileName,file1)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        return KycDetail.builder().docName(key).docURL(fileUrl).build();
    }

    private File convertMultiParttoFile(MultipartFile file) {
        File conFile = new File(file.getOriginalFilename());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(conFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return conFile;
    }
}
