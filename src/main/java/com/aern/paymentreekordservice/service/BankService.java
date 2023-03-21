package com.aern.paymentreekordservice.service;

import com.aern.paymentreekordservice.entity.BankEntity;
import com.aern.paymentreekordservice.model.BankDetail;
import com.aern.paymentreekordservice.repository.BankDetailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private final BankDetailRepository bankRepository;

    public BankService(BankDetailRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
    public void updateBankDetails(String phoneNumber, BankDetail bankDetail) {
        BankEntity bankEntity = new BankEntity();
        BeanUtils.copyProperties(bankDetail,bankEntity);
        bankRepository.save(bankEntity);
    }
}
