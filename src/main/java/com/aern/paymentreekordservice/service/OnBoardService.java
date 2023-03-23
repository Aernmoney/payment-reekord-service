package com.aern.paymentreekordservice.service;

import com.aern.paymentreekordservice.entity.AddressEntity;
import com.aern.paymentreekordservice.entity.CustomerEntity;
import com.aern.paymentreekordservice.model.CustomerDetail;
import com.aern.paymentreekordservice.model.ResendOtp;
import com.aern.paymentreekordservice.repository.AddressRepository;
import com.aern.paymentreekordservice.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class OnBoardService {

    private final SNSService snsService;
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    public OnBoardService(SNSService snsService, AddressRepository addressRepository,
                          CustomerRepository customerRepository) {
        this.snsService = snsService;
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void onBoardUser(CustomerDetail customerDetail) {
        CustomerEntity customer = new CustomerEntity();
        if (customerRepository.existsByPhoneNumber(customerDetail.getPhoneNumber())) {
            customer = customerRepository.findByPhoneNumber(customerDetail.getPhoneNumber());
            String phoneNumber = "+91" + customerDetail.getPhoneNumber();
            String otpNumber = String.format("%04d", new Random().nextInt(1000));
            String message = "Your verification code is " + otpNumber + " " + "\nThank you\n" + customerDetail.getHaskKey();
            snsService.sendTextSMS(phoneNumber, message);
            customer.setOtpNumber(otpNumber);
            customerRepository.save(customer);
            return;
        }

        AddressEntity address = new AddressEntity();
        BeanUtils.copyProperties(customerDetail.getBusinessAddress(), address);
        addressRepository.save(address);

        BeanUtils.copyProperties(customerDetail, customer);
        address.setCustomer(customer);
        customer.getAddresses().add(address);

        String phoneNumber = "+91" + customerDetail.getPhoneNumber();
        String otpNumber = String.format("%04d", new Random().nextInt(1000));
        String message = "Your verification code is " + otpNumber + " " + "\nThank you\n" + customerDetail.getHaskKey();
        snsService.sendTextSMS(phoneNumber, message);
        customer.setOtpNumber(otpNumber);
        customerRepository.save(customer);
    }

    public void resendOtp(ResendOtp resendOtp) {
        CustomerEntity entity = customerRepository.findByPhoneNumber(resendOtp.getPhoneNumber());
        if (entity != null) {
            String phoneNumber = "+91" + resendOtp.getPhoneNumber();
            String otpNumber = entity.getOtpNumber();
            String message = "Your verification code is " + otpNumber + " " + "\nThank you\n" + resendOtp.getHashKey();
            snsService.sendTextSMS(phoneNumber,message);
        } else {
            String phoneNumber = "+91" + resendOtp.getPhoneNumber();
            String otpNumber = String.format("%04d", new Random().nextInt(1000));
            String message = "Your verification code is " + otpNumber + " " + "\nThank you\n" + resendOtp.getHashKey();
            snsService.sendTextSMS(phoneNumber,message);
            entity.setOtpNumber(otpNumber);
            customerRepository.save(entity);
        }
    }
}