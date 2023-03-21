package com.aern.paymentreekordservice.service;

import com.aern.paymentreekordservice.entity.KycEntity;
import com.aern.paymentreekordservice.model.KycDetail;
import com.aern.paymentreekordservice.repository.KycRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KycService {

    private final KycRepository kycRepository;

    public KycService(KycRepository kycRepository) {
        this.kycRepository = kycRepository;
    }

    @Transactional
    public void updateKycDetails(String phoneNumber,List<KycDetail> kycDetailList) {
       for(KycDetail kycDetail : kycDetailList) {
           KycEntity kycEntity = new KycEntity();
           if (kycRepository.existsByPhoneNumberAndDocNumber(phoneNumber,kycDetail.getDocNumber())) {
               kycEntity = kycRepository.findByPhoneNumberAndDocNumber(phoneNumber,kycDetail.getDocNumber());
               BeanUtils.copyProperties(kycDetail,kycEntity);
           } else {
               BeanUtils.copyProperties(kycDetail, kycEntity);
               kycEntity.setPhoneNumber(phoneNumber);
           }
           kycRepository.save(kycEntity);
       }
    }
}
