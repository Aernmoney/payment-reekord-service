package com.aern.paymentreekordservice.repository;

import com.aern.paymentreekordservice.entity.BankEntity;
import com.aern.paymentreekordservice.model.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailRepository extends JpaRepository<BankEntity,Long> {
}
