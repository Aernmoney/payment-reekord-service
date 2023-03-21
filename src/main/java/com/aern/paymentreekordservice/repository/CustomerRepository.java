package com.aern.paymentreekordservice.repository;

import com.aern.paymentreekordservice.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    CustomerEntity findByPhoneNumberAndOtpNumber(String phoneNumber, String otpNumber);

    boolean existsByPhoneNumber(String phoneNumber);

    CustomerEntity findByPhoneNumber(String phoneNumber);
}
