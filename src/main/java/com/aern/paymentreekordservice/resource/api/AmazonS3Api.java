package com.aern.paymentreekordservice.resource.api;

import com.aern.paymentreekordservice.model.KycDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(path = "/api/v1/upload")
public interface AmazonS3Api {

    @PutMapping(path = "/{phoneNumber}")
    public ResponseEntity<KycDetail> uploadFile(@PathVariable String phoneNumber,
                                                @RequestParam("file") MultipartFile multipartFile,
                                                @RequestParam("key") String key);
}
