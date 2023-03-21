package com.aern.paymentreekordservice.resource.api;

import com.aern.paymentreekordservice.model.AuthenticationRequest;
import com.aern.paymentreekordservice.model.AuthenticationResponse;
import com.aern.paymentreekordservice.model.BankDetail;
import com.aern.paymentreekordservice.model.CustomerDetail;
import com.aern.paymentreekordservice.model.KycDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/api/v1/onboard")
public interface OnBoardApi {

    @PostMapping(path = "/login")
    ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authenticationRequest);
    @PostMapping(path = "/customer-detail",consumes = {"application/json"})
    ResponseEntity<?> onBoardUser(@RequestBody CustomerDetail customerDetail);

    @PutMapping(path = "/kyc-detail/{phoneNumber}",consumes = {"application/json"})
    ResponseEntity<?> kycDetails(@PathVariable String phoneNumber,
                                 @RequestBody List<KycDetail> kycDetailList);

    @PutMapping(path = "/bank-detail/{phoneNumber}" , consumes = {"application/json"})
    ResponseEntity<?> bankDetails(@PathVariable String phoneNumber,
                                  @RequestBody BankDetail bankDetail);
}
