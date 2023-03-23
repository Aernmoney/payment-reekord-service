package com.aern.paymentreekordservice.resource.controller;

import com.aern.paymentreekordservice.model.AuthenticationRequest;
import com.aern.paymentreekordservice.model.AuthenticationResponse;
import com.aern.paymentreekordservice.model.BankDetail;
import com.aern.paymentreekordservice.model.CustomerDetail;
import com.aern.paymentreekordservice.model.KycDetail;
import com.aern.paymentreekordservice.model.ResendOtp;
import com.aern.paymentreekordservice.resource.api.OnBoardApi;
import com.aern.paymentreekordservice.service.AuthenticationService;
import com.aern.paymentreekordservice.service.BankService;
import com.aern.paymentreekordservice.service.KycService;
import com.aern.paymentreekordservice.service.OnBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OnBoardController implements OnBoardApi {

    private final OnBoardService onBoardService;
    private final KycService kycService;
    private final BankService bankService;
    private final AuthenticationService authenticationService;

    public OnBoardController(OnBoardService onBoardService, KycService kycService,
                             BankService bankService, AuthenticationService authenticationService) {
        this.onBoardService = onBoardService;
        this.kycService = kycService;
        this.bankService = bankService;
        this.authenticationService = authenticationService;
    }

    @Override
    public ResponseEntity<AuthenticationResponse> login(AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authResponse = authenticationService.login(authenticationRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(authResponse);
    }

    @Override
    public ResponseEntity<?> onBoardUser(CustomerDetail customerDetail) {
        onBoardService.onBoardUser(customerDetail);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @Override
    public ResponseEntity<?> kycDetails(String phoneNumber,List<KycDetail> kycDetailList) {
        kycService.updateKycDetails(phoneNumber, kycDetailList);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @Override
    public ResponseEntity<?> bankDetails(String phoneNumber, BankDetail bankDetail) {
        bankService.updateBankDetails(phoneNumber,bankDetail);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @Override
    public ResponseEntity<?> resendOtp(ResendOtp resendOtp) {
        onBoardService.resendOtp(resendOtp);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
