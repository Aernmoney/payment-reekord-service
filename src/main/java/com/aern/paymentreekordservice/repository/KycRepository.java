package com.aern.paymentreekordservice.repository;

import com.aern.paymentreekordservice.entity.KycEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KycRepository extends JpaRepository<KycEntity , Long> {
    boolean existsByPhoneNumberAndDocNumber(String phoneNumber, String docNumber);

    KycEntity findByPhoneNumberAndDocNumber(String phoneNumber, String docNumber);
}
