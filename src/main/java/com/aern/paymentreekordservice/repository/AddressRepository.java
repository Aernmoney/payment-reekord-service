package com.aern.paymentreekordservice.repository;

import com.aern.paymentreekordservice.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
}
